package com.ttrpg.quadraticwiz.repository.impl;

import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.repository.MongoCollection;
import com.ttrpg.quadraticwiz.repository.api.NPCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;

@Repository
@RequiredArgsConstructor
public class NPCRepositoryImpl implements NPCRepository {

    private final MongoTemplate mongoTemplate;

    @Override public BaseNPC getNPCById(String id) {
        return mongoTemplate.findAndModify(new Query().addCriteria(Criteria.where("_id").is(id)),
                new Update().set("updateDate", LocalDate.now(ZoneId.systemDefault())),
                BaseNPC.class, "npc");
    }

    @Override public String saveNPC(BaseNPC npc) {
        return mongoTemplate.save(npc, "npc").get_id();
    }

    @Override public void removeOldNpcs() {
        mongoTemplate.findAllAndRemove(new Query().addCriteria(Criteria.where("updateDate").lte(LocalDate.now(ZoneId.systemDefault()).minusYears(1))),
                MongoCollection.NPC.label);
    }

}
