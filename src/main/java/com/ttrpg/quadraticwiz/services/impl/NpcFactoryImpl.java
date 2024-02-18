package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.domain.Systems;
import com.ttrpg.quadraticwiz.domain.npc.enums.Tags;
import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.repositories.entities.MothershipNpcEntity;
import com.ttrpg.quadraticwiz.services.api.AttributeService;
import com.ttrpg.quadraticwiz.services.api.NpcFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NpcFactoryImpl implements NpcFactory {

    private final AttributeService attributeService;

    @Override public BaseNpcEntity generateNpc(Systems npcType, String... tagArr) {
        List<String> tags = new ArrayList<>();

        if (tagArr != null) Collections.addAll(tags, tagArr);
        if (!tags.contains(Tags.BASE.name())) tags.add(Tags.BASE.name());

        switch (npcType) {
            case DND5E:
                return generateDndPC(tags);
            case MOTHERSHIP:
                return generateMoshNpc(tags);
            case OSROTHER:
                return generateOSRNpc(tags);
            default:
                return generateBaseNpc(tags);
        }
    }

    private BaseNpcEntity generateBaseAttributes(List<String> tags, BaseNpcEntity npc) {

        npc.setSize(attributeService.getSize(tags));
        npc.setBodySurface(attributeService.generateNpcAttribute(MongoCollection.BODY_SURFACE, tags));
        npc.setBodyShape(attributeService.generateNpcAttribute(MongoCollection.BODY_SHAPE, tags));
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement(tags));
        npc.setPeculiarCharacteristic(attributeService.generateNpcAttribute(MongoCollection.PECULIAR_CHARACTERISTIC,
                tags));
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setUpdateDate(LocalDate.now(ZoneId.systemDefault()));

        return npc;
    }

    @Override public BaseNpcEntity generateBaseNpc(List<String> tags) {
        return generateBaseAttributes(tags, new BaseNpcEntity());
    }

    @Override public MothershipNpcEntity generateMoshNpc(List<String> tags) {
        MothershipNpcEntity npc = new MothershipNpcEntity();
        tags.add(Systems.MOTHERSHIP.name());
        generateBaseAttributes(tags, npc);

        // Mothership-specific Stuff
        npc.setCombat(AttributeService.generateCombatAttr(npc.getSize().getMoshMod()));
        npc.setLoyalty(AttributeService.generateLoyaltyAttr());
        npc.setInstinct(AttributeService.generateInstinctAttr());
        npc.setHits(AttributeService.generateHitsAttr(npc.getSize().getMoshHitDie())
                + "(" + AttributeService.generateHealthPoints(6, 10, npc.getSize().getMoshMod()) + ")");

        return npc;
    }

    // TODO Finish
    @Override public BaseNpcEntity generateDndPC(List<String> tags) {
        BaseNpcEntity npc = new BaseNpcEntity();

        return npc;
    }

    // TODO Finish
    @Override public BaseNpcEntity generateOSRNpc(List<String> tags) {
        BaseNpcEntity npc = new BaseNpcEntity();

        return npc;
    }
}
