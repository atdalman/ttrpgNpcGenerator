package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.*;
import com.ttrpg.quadraticwiz.repositories.api.AttributeRepository;
import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.services.api.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    @Override public WeightedAttribute generateWeightedNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (WeightedAttribute) attributeRepository.getRandomWeightedNPCAttribute(mongoCollection.label, tags,
                WeightedAttribute.class);
    }

    @Override public Size getSize(List<String> tags) {
        return (Size) attributeRepository.getRandomWeightedNPCAttribute(MongoCollection.SIZE.label, tags,
                Size.class);
    }

    @Override public NPCAttribute generateNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (NPCAttribute) attributeRepository.getRandomNPCAttribute(mongoCollection.label, tags, NPCAttribute.class);
    }

    @Override public Movement getMovement(List<String> tags) {
        return (Movement) attributeRepository.getRandomNPCAttribute(MongoCollection.MOVEMENT.label, tags, Movement.class);

    }

    @Override public List<NPCAttribute> getCombatStrategies() {
        return attributeRepository.getMultipleAttributes(2, MongoCollection.COMBAT_STRATEGY.label);
    }

    @Override public List<NPCAttribute> getMotivations() {
        return attributeRepository.getMultipleAttributes(2, MongoCollection.MOTIVATION.label);
    }

    }
