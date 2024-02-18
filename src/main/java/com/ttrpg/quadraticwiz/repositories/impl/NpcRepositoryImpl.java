package com.ttrpg.quadraticwiz.repositories.impl;

import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.repositories.api.NpcRepository;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class NpcRepositoryImpl implements NpcRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public BaseNpcEntity getNpcById(UUID npcId) {
        BaseNpcEntity entity = mongoTemplate.findAndModify(
                new Query().addCriteria(Criteria.where("_id").is(npcId)),
                new Update().set("updateDate", LocalDate.now(ZoneId.systemDefault())),
                BaseNpcEntity.class, "npc");

        return entity;
    }

    @Override
    public BaseNpcEntity saveNpc(BaseNpcEntity npc) {
        return mongoTemplate.save(npc, "npc");
    }

    @Override
    public void removeOldNpcs() {
        mongoTemplate.findAllAndRemove(new Query().addCriteria(Criteria.where("updateDate").lte(LocalDate.now(ZoneId.systemDefault()).minusYears(1))),
                MongoCollection.Npc.label);
    }

}
