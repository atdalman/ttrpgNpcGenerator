package osr.monsterGenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.stereotype.Repository;
import osr.monsterGenerator.npc.npcAttributes.DistinctiveFeature;

import java.util.List;

@Repository
public class AttributeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Object getSingleRandomAttribute(Class desiredClass) {
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        Object result = mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(desiredClass),
                desiredClass).getUniqueMappedResult();
        return result;
    }

    public List<Object> getMultipleRandomAttributes(Object collectionName, int numResults) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = Aggregation.newAggregation(sampleStage);
        AggregationResults<DistinctiveFeature> output = mongoTemplate.aggregate(aggregation, "distinctiveFeature",
                DistinctiveFeature.class);
        return null;
    }
}
