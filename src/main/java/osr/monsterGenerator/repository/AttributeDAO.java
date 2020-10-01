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
import osr.monsterGenerator.model.CumulativeChance;
import osr.monsterGenerator.model.npc.npcAttributes.CombatStrategy;
import osr.monsterGenerator.model.npc.npcAttributes.Motivation;
import osr.monsterGenerator.model.npc.npcAttributes.WeightedAttribute;
import osr.monsterGenerator.utilities.RandomUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
public class AttributeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Equally weighted attributes
    public Object getSingleRandomAttribute(Class desiredClass) {
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(desiredClass),
                desiredClass).getUniqueMappedResult();
    }

    // Unequally weighted attributes
    public WeightedAttribute getSingleRandomAttributeUsingChance(String collectionName) {
        double chanceSum = getChanceByAttributeName(collectionName);
        double rand = RandomUtils.getRandomDouble() * chanceSum;
        Query find = new Query();


        find.fields().exclude("_id");
        List<WeightedAttribute> results = mongoTemplate.find(find, WeightedAttribute.class, collectionName);

        for (WeightedAttribute curr : results) {
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

    // Updates chances within each document within a given collection of attributes
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