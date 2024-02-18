package com.ttrpg.quadraticwiz.repositories.impl;

import com.ttrpg.quadraticwiz.domain.npc.dtos.NpcAttribute;
import com.ttrpg.quadraticwiz.mappers.EntityMapper;
import com.ttrpg.quadraticwiz.repositories.api.AttributeRepository;
import com.ttrpg.quadraticwiz.repositories.entities.NpcAttributeEntity;
import com.ttrpg.quadraticwiz.repositories.entities.WeightedAttributeEntity;
import com.ttrpg.quadraticwiz.utilities.CumulativeChance;
import com.ttrpg.quadraticwiz.utilities.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
@RequiredArgsConstructor
public class AttributeRepositoryImpl implements AttributeRepository {

    private final MongoTemplate mongoTemplate;
    private final EntityMapper entityMapper;

    // Equally weighted attributes
    @Override
    public Object getRandomNpcAttribute(String collectionName, List<String> tags,
                                        Class attributeClass) {
        MatchOperation matchStage = Aggregation.match(new Criteria("tags").in(tags));
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggOp = Aggregation.newAggregation(matchStage, sampleStage);

        return mongoTemplate.aggregate(aggOp, collectionName, attributeClass).getUniqueMappedResult();
    }

    // Unequally weighted attributes.
    @Override
    public Object getRandomWeightedNpcAttribute(String collectionName,
                                                List<String> tags, Class attributeClass) {
        double chanceSum = getChanceByAttributeName(collectionName);
        double rand = RandomUtils.getRandomDouble() * chanceSum;

        Query find = new Query();
        List<WeightedAttributeEntity> results = mongoTemplate.find(find, attributeClass, collectionName);

        for (WeightedAttributeEntity curr : results) {
            if (curr.getChanceSum() >= rand) {
                return curr;
            }
        }

        return null;
    }

    @Override
    public List<NpcAttribute> getMultipleAttributes(int numResults, String collectionName) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = newAggregation(sampleStage);
        AggregationResults<NpcAttributeEntity> output = mongoTemplate.aggregate(aggregation,
                collectionName, NpcAttributeEntity.class);
        return output.getMappedResults().stream().map(entityMapper::toNpcAttribute).toList();
    }

    // **** Chance Attribute Updates ****
    private double getChanceByAttributeName(String attributeName) {
        return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("attribute").is(attributeName)),
                CumulativeChance.class, "cumulativeChance").getCumulativeChance();
    }

    // Updates chances within each document within a given collection of attributes
    @Override
    public void updateChances(String collectionName) {
        List<WeightedAttributeEntity> results = mongoTemplate.findAll(WeightedAttributeEntity.class, collectionName);

        double chanceSum = 0;
        for (WeightedAttributeEntity curr : results) {
            chanceSum += curr.getChance();
            curr.setChanceSum(chanceSum);
            mongoTemplate.save(curr, collectionName);
        }

        updateCumulativeChanceCollection(collectionName, chanceSum);
    }

    // Updates sum of chances for a given collection
    private void updateCumulativeChanceCollection(String collectionName, double chanceSum) {
        String cumulativeChance = "cumulativeChance";
        Query query = new Query();
        query.addCriteria(Criteria.where("attribute").is(collectionName));
        Update update = new Update();
        update.set("cumulativeChance", chanceSum);
        update.set("updateDate", LocalDateTime.now());
        mongoTemplate.upsert(query, update, cumulativeChance);
    }
}