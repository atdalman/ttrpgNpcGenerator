package osr.monsterGenerator.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import osr.monsterGenerator.model.npc.npcAttributes.CombatStrategy;
import osr.monsterGenerator.model.npc.npcAttributes.Motivation;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class AttributeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object getSingleRandomAttribute(Class desiredClass) {
        // TODO Need to fix weighted selections

        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(desiredClass),
                desiredClass).getUniqueMappedResult();
    }

    public void updateCumulativeChanceByCollection(String collectionName) {
        String cumulativeChance = "cumulativeChance";
        Aggregation agg = newAggregation(group().sum("chance").as(cumulativeChance),
                project(cumulativeChance));
        AggregationResults<Document> results = mongoTemplate.aggregate(agg, collectionName, Document.class);
        Double result = results.getUniqueMappedResult().getDouble(cumulativeChance);

        Query query = new Query();
        query.addCriteria(Criteria.where(cumulativeChance).exists(true));
        Update update = new Update();
        update.set(cumulativeChance, result);
        update.set("updateDate", LocalDateTime.now());
        mongoTemplate.upsert(query, update, collectionName);
    }

    public void getRandomAttributeByChanceScore(String collectionName, Class desiredClass) {
        List<desiredClass . class>
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