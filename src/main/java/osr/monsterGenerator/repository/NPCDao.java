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
        return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(id)),
                BaseNPC.class, "npc");
    }

    public String saveNPC(BaseNPC npc) {
        return mongoTemplate.save(npc, "npc").getId();
    }

}
