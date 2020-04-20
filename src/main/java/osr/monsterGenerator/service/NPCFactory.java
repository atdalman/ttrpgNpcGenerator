package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.npc.NPC;

@Service
public class NPCFactory {

    public static NPC generateMonster(String npcType){
        if(npcType.equalsIgnoreCase("monster")) return new DndNPC();
        else {
            return null;
        }
    }
}
