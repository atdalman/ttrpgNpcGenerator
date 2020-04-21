package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.npc.MothershipNPC;
import osr.monsterGenerator.npc.BaseNPC;
import osr.monsterGenerator.npc.OtherOSRNPC;
import osr.monsterGenerator.utilities.Systems;

@Service
public class NPCFactory {

    public static BaseNPC generateMonster(Systems npcType){
        switch(npcType){
            case DND5E:
                return new DndNPC();
            case MOTHERSHIP:
                return new MothershipNPC();
            case OSROTHER:
                return new OtherOSRNPC();
            default:
                return new BaseNPC();
        }

    }
}
