package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.domain.npc.dtos.NpcAttribute;
import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.repositories.api.AttributeRepository;
import com.ttrpg.quadraticwiz.repositories.entities.MovementEntity;
import com.ttrpg.quadraticwiz.repositories.entities.NpcAttributeEntity;
import com.ttrpg.quadraticwiz.repositories.entities.SizeEntity;
import com.ttrpg.quadraticwiz.repositories.entities.WeightedAttributeEntity;
import com.ttrpg.quadraticwiz.services.api.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    @Override
    public WeightedAttributeEntity generateWeightedNpcAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (WeightedAttributeEntity) attributeRepository.getRandomWeightedNpcAttribute(mongoCollection.label, tags,
                WeightedAttributeEntity.class);
    }

    @Override
    public SizeEntity getSize(List<String> tags) {
        return (SizeEntity) attributeRepository.getRandomWeightedNpcAttribute(MongoCollection.SIZE.label, tags,
                SizeEntity.class);
    }

    @Override
    public NpcAttributeEntity generateNpcAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (NpcAttributeEntity) attributeRepository.getRandomNpcAttribute(mongoCollection.label, tags, NpcAttributeEntity.class);
    }

    @Override
    public MovementEntity getMovement(List<String> tags) {
        return (MovementEntity) attributeRepository.getRandomNpcAttribute(MongoCollection.MOVEMENT.label, tags, MovementEntity.class);

    }

    @Override
    public List<NpcAttribute> getCombatStrategies() {
        return attributeRepository.getMultipleAttributes(2, MongoCollection.COMBAT_STRATEGY.label);
    }

    @Override
    public List<NpcAttribute> getMotivations() {
        return attributeRepository.getMultipleAttributes(2, MongoCollection.MOTIVATION.label);
    }

    }
