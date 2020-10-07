package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.model.npc.DndNPC;
import osr.monsterGenerator.model.npc.MothershipNPC;
import osr.monsterGenerator.model.npc.OtherOSRNPC;

import java.time.LocalDateTime;

@Service
public class NPCFactory {

    @Autowired
    private AttributeService attributeService;

    public BaseNPC generateNPC(Systems npcType) {
        switch (npcType) {
            case DND5E:
                return new DndNPC();
            case MOTHERSHIP:
                return generateMoshNPC();
            case OSROTHER:
                return new OtherOSRNPC();
            default:
                return generateBaseNPC();
        }
    }

    public BaseNPC generateBaseNPC() {
        BaseNPC npc = new BaseNPC();
        npc.setSize(attributeService.getSize());
        npc.setBodySurface(attributeService.getBodySurface());
        npc.setGeneralBodyShape(attributeService.getBodyShape());
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement());
        npc.setDistinctiveFeature(attributeService.getDistinctiveFeature());
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setInsertDate(LocalDateTime.now());

        return npc;
    }

    public MothershipNPC generateMoshNPC() {
        MothershipNPC npc = new MothershipNPC();
        npc.setSize(attributeService.getSize());
        npc.setBodySurface(attributeService.getBodySurface());
        npc.setGeneralBodyShape(attributeService.getBodyShape());
        npc.setMotivations(attributeService.getMotivations());
        npc.setMovement(attributeService.getMovement());
        npc.setDistinctiveFeature(attributeService.getDistinctiveFeature());
        npc.setCombatStrategies(attributeService.getCombatStrategies());
        npc.setInsertDate(LocalDateTime.now());

        // Mothership-specific Stuff
        npc.setCombat(AttributeService.generateCombatAttr(npc.getSize().getMoshMod()));
        npc.setLoyalty(AttributeService.generateLoyaltyAttr());
        npc.setInstinct(AttributeService.generateInstinctAttr());
        npc.setHealthPoints(AttributeService.generateHealthPoints(6, 10, npc.getSize().getMoshMod()));
        npc.setHits(AttributeService.generateHitsAttr(npc.getSize().getMoshHitDie()) + "(" + npc.getHealthPoints() +
                ")");

        return npc;
    }
}
