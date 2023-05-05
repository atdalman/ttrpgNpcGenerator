package ttrpg.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttrpg.monsterGenerator.model.Systems;
import ttrpg.monsterGenerator.model.npc.BaseNPC;
import ttrpg.monsterGenerator.repository.NPCDao;

@Service
public class NPCService {

    @Autowired
    NPCDao npcDao;

    @Autowired
    NPCFactory npcFactory;

    public BaseNPC generateNPC(Systems npcSystem, String... tags) {
        BaseNPC npc = npcFactory.generateNPC(npcSystem, tags);
        npcDao.saveNPC(npc);
        return npc;
    }

    public BaseNPC getNPCById(String id) {
        return npcDao.getNPCById(id);
    }
}
