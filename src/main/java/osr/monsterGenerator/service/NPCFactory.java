package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.model.npc.DndNPC;
import osr.monsterGenerator.model.npc.MothershipNPC;
import osr.monsterGenerator.model.npc.OtherOSRNPC;

@Service
public class NPCFactory {

    @Autowired
    private AttributeService attributeService;

    public BaseNPC generateNPC(Systems npcType) {
        switch (npcType) {
            case DND5E:
                return new DndNPC();
            case MOTHERSHIP:
                return new MothershipNPC();
            case OSROTHER:
                return new OtherOSRNPC();
            case BASE:
                return new BaseNPC();
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

        return npc;
    }
}
