package com.ttrpg.quadraticwiz.service.impl;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.*;
import com.ttrpg.quadraticwiz.repository.api.AttributeDAO;
import com.ttrpg.quadraticwiz.repository.MongoCollection;
import com.ttrpg.quadraticwiz.service.api.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeDAO attributeDAO;

    @Override public WeightedAttribute generateWeightedNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (WeightedAttribute) attributeDAO.getRandomWeightedNPCAttribute(mongoCollection.label, tags,
                WeightedAttribute.class);
    }

    @Override public Size getSize(List<String> tags) {
        return (Size) attributeDAO.getRandomWeightedNPCAttribute(MongoCollection.SIZE.label, tags,
                Size.class);
    }

    @Override public NPCAttribute generateNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (NPCAttribute) attributeDAO.getRandomNPCAttribute(mongoCollection.label, tags, NPCAttribute.class);
    }

    @Override public Movement getMovement(List<String> tags) {
        return (Movement) attributeDAO.getRandomNPCAttribute(MongoCollection.MOVEMENT.label, tags, Movement.class);

    }

    @Override public List<NPCAttribute> getCombatStrategies() {
        return attributeDAO.getMultipleAttributes(2, MongoCollection.COMBAT_STRATEGY.label);
    }

    @Override public List<NPCAttribute> getMotivations() {
        return attributeDAO.getMultipleAttributes(2, MongoCollection.MOTIVATION.label);
    }

    }
