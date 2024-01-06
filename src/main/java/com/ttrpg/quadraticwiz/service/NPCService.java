package com.ttrpg.quadraticwiz.service;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.repository.NPCDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NPCService {

    private final NPCDao npcDao;

    private final NPCFactory npcFactory;

    public BaseNPC generateNPC(Systems npcSystem, String... tags) {
        BaseNPC npc = npcFactory.generateNPC(npcSystem, tags);
        npcDao.saveNPC(npc);
        return npc;
    }

    public BaseNPC getNPCById(String id) {
        return npcDao.getNPCById(id);
    }
}
