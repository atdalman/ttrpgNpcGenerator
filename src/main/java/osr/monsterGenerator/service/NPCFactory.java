package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.npc.Monster;

@Service
public class NPCFactory {

    public Monster generateMonster(String npcType){
        if(npcType.equalsIgnoreCase("monster")) return new Monster();
        else {
            return null;
        }
    }
}
