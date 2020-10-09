package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.repository.NPCDao;

@Service
public class NPCService {

    @Autowired
    NPCDao npcDao;

    @Autowired
    NPCFactory npcFactory;

    public BaseNPC generateNPC(Systems npcSystem) {
        BaseNPC npc = npcFactory.generateNPC(npcSystem);
        npcDao.saveNPC(npc);
        return npc;
    }

    public BaseNPC getNPCById(String id) {
        return npcDao.getNPCById(id);
    }
}
