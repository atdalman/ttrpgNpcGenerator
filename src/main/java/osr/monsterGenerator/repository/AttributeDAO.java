package osr.monsterGenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import osr.monsterGenerator.model.npc.CumulativeChance;
import osr.monsterGenerator.model.npc.npcAttributes.CombatStrategy;
import osr.monsterGenerator.model.npc.npcAttributes.Motivation;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.model.npc.npcAttributes.WeightedAttribute;
import osr.monsterGenerator.utilities.RandomUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
public class AttributeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object getSingleRandomAttribute(Class desiredClass) {
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(desiredClass),
                desiredClass).getUniqueMappedResult();
    }

    public Size getSingleRandomAttributeUsingChance(String collectionName) {
        double chanceSum = getChanceByAttributeName(collectionName);
        double rand = RandomUtils.getRandomDouble() * chanceSum;
        List<Size> results = mongoTemplate.findAll(Size.class, collectionName);

        for (Size curr : results) {
            if (curr.getChanceSum() >= rand) {
                return curr;
            }
        }

        return null;
    }

    private double getChanceByAttributeName(String attributeName) {
        return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("attribute").is(attributeName)),
                CumulativeChance.class, "cumulativeChance").getCumulativeChance();
    }

    // Updates chances within each document within a given attribute collection
    public void updateChances(String collectionName) {
        List<WeightedAttribute> results = mongoTemplate.findAll(WeightedAttribute.class, collectionName);

        double chanceSum = 0;
        for (WeightedAttribute curr : results) {
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

    // TODO Candidate for removal
    public List<Object> getMultipleRandomAttributes(Class desiredClass, int numResults) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = newAggregation(sampleStage);
        AggregationResults<Object> output = mongoTemplate.aggregate(aggregation,
                mongoTemplate.getCollectionName(desiredClass), desiredClass);
        return output.getMappedResults();
    }

    public List<Motivation> getNPCMotivations(int numResults) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = newAggregation(sampleStage);
        AggregationResults<Motivation> output = mongoTemplate.aggregate(aggregation,
                mongoTemplate.getCollectionName(Motivation.class), Motivation.class);
        return output.getMappedResults();
    }

    public List<CombatStrategy> getCombatStrategies(int numResults) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = newAggregation(sampleStage);
        AggregationResults<CombatStrategy> output = mongoTemplate.aggregate(aggregation,
                mongoTemplate.getCollectionName(CombatStrategy.class), CombatStrategy.class);
        return output.getMappedResults();
    }
}