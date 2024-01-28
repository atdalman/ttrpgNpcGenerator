package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.model.npc.MothershipNPC;
import com.ttrpg.quadraticwiz.model.npc.Tags;
import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.services.api.AttributeService;
import com.ttrpg.quadraticwiz.services.api.NPCFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NPCFactoryImpl implements NPCFactory {

    private final AttributeService attributeService;

    @Override public BaseNPC generateNPC(Systems npcType, String... tagArr) {
        List<String> tags = new ArrayList<>();

        if (tagArr != null) Collections.addAll(tags, tagArr);
        if (!tags.contains(Tags.BASE.name())) tags.add(Tags.BASE.name());

        switch (npcType) {
            case DND5E:
                return generateDndPC(tags);
            case MOTHERSHIP:
                return generateMoshNPC(tags);
            case OSROTHER:
                return generateOSRNPC(tags);
            default:
                return generateBaseNPC(tags);
        }
    }

    private BaseNPC generateBaseAttributes(List<String> tags, BaseNPC npc) {

        npc.setSize(attributeService.getSize(tags));
        npc.setBodySurface(attributeService.generateNPCAttribute(MongoCollection.BODY_SURFACE, tags));
        npc.setBodyShape(attributeService.generateNPCAttribute(MongoCollection.BODY_SHAPE, tags));
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement(tags));
        npc.setPeculiarCharacteristic(attributeService.generateNPCAttribute(MongoCollection.PECULIAR_CHARACTERISTIC,
                tags));
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setUpdateDate(LocalDate.now(ZoneId.systemDefault()));

        return npc;
    }

    @Override public BaseNPC generateBaseNPC(List<String> tags) {
        return generateBaseAttributes(tags, new BaseNPC());
    }

    @Override public MothershipNPC generateMoshNPC(List<String> tags) {
        MothershipNPC npc = new MothershipNPC();
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
    @Override public BaseNPC generateDndPC(List<String> tags) {
        BaseNPC npc = new BaseNPC();

        return npc;
    }

    // TODO Finish
    @Override public BaseNPC generateOSRNPC(List<String> tags) {
        BaseNPC npc = new BaseNPC();

        return npc;
    }
}
