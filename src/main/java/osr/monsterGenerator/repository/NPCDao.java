package osr.monsterGenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import osr.monsterGenerator.model.npc.BaseNPC;

@Repository
public class NPCDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public BaseNPC getNPCById(String id) {
        return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("npcId").is(id)),
                BaseNPC.class, "npc");
    }

}
