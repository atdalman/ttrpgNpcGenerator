package com.ttrpg.quadraticwiz.service;

import com.ttrpg.quadraticwiz.repository.NPCDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;

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
