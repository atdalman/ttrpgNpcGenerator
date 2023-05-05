package ttrpg.monsterGenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ttrpg.monsterGenerator.model.CumulativeChance;
import ttrpg.monsterGenerator.model.npc.npcAttributes.NPCAttribute;
import ttrpg.monsterGenerator.model.npc.npcAttributes.WeightedAttribute;
import ttrpg.monsterGenerator.utilities.RandomUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@Repository
public class AttributeDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Equally weighted attributes
    public Object getRandomNPCAttribute(String collectionName, List<String> tags,
                                        Class attributeClass) {
        MatchOperation matchStage = Aggregation.match(new Criteria("tags").in(tags));
        SampleOperation sampleStage = Aggregation.sample(1);
        Aggregation aggOp = Aggregation.newAggregation(matchStage, sampleStage);

        return mongoTemplate.aggregate(aggOp, collectionName, attributeClass).getUniqueMappedResult();
    }

    // Unequally weighted attributes.
    public Object getRandomWeightedNPCAttribute(String collectionName,
                                                List<String> tags, Class attributeClass) {
        double chanceSum = getChanceByAttributeName(collectionName);
        double rand = RandomUtils.getRandomDouble() * chanceSum;

        Query find = new Query();
        List<WeightedAttribute> results = mongoTemplate.find(find, attributeClass, collectionName);

        for (WeightedAttribute curr : results) {
            if (curr.getChanceSum() >= rand) {
                return curr;
            }
        }

        return null;
    }

    public List<NPCAttribute> getMultipleAttributes(int numResults, String collectionName) {
        SampleOperation sampleStage = Aggregation.sample(numResults);
        Aggregation aggregation = newAggregation(sampleStage);
        AggregationResults<NPCAttribute> output = mongoTemplate.aggregate(aggregation,
                collectionName, NPCAttribute.class);
        return output.getMappedResults();
    }

    // **** Chance Attribute Updates ****
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
}