package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.model.npc.MothershipNPC;
import osr.monsterGenerator.repository.MongoCollection;

import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class NPCFactory {

    @Autowired
    private AttributeService attributeService;

    public BaseNPC generateNPC(Systems npcType, String... tags) {
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

    public BaseNPC generateBaseNPC(String... tags) {
        BaseNPC npc = new BaseNPC();
        npc.setSize(attributeService.getSize());
        npc.setBodySurface(attributeService.generateNPCAttribute(MongoCollection.BODY_SURFACE, tags));
        npc.setBodyShape(attributeService.generateNPCAttribute(MongoCollection.BODY_SHAPE, tags));
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement());
        npc.setPeculiarCharacteristic(attributeService.generateNPCAttribute(MongoCollection.PECULIAR_CHARACTERISTIC,
                tags));
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setUpdateDate(LocalDate.now(ZoneId.systemDefault()));

        return npc;
    }

    // TODO Finish
    public BaseNPC generateDndPC(String... tags) {
        BaseNPC npc = new BaseNPC();

        return npc;
    }

    // TODO Finish
    public BaseNPC generateOSRNPC(String... tags) {
        BaseNPC npc = new BaseNPC();

        return npc;
    }

    public MothershipNPC generateMoshNPC(String... tags) {
        MothershipNPC npc = new MothershipNPC();
        npc.setSize(attributeService.getSize());
        npc.setBodySurface(attributeService.generateNPCAttribute(MongoCollection.BODY_SURFACE, tags));
        npc.setBodyShape(attributeService.generateNPCAttribute(MongoCollection.BODY_SHAPE, tags));
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement());
        npc.setPeculiarCharacteristic(attributeService.generateNPCAttribute(MongoCollection.PECULIAR_CHARACTERISTIC, tags));
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setUpdateDate(LocalDate.now(ZoneId.systemDefault()));

        // Mothership-specific Stuff
        npc.setCombat(AttributeService.generateCombatAttr(npc.getSize().getMoshMod()));
        npc.setLoyalty(AttributeService.generateLoyaltyAttr());
        npc.setInstinct(AttributeService.generateInstinctAttr());
        npc.setHits(AttributeService.generateHitsAttr(npc.getSize().getMoshHitDie())
                + "(" + AttributeService.generateHealthPoints(6, 10, npc.getSize().getMoshMod()) + ")");

        return npc;
    }
}
