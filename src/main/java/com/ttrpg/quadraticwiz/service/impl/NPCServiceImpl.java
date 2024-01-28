package com.ttrpg.quadraticwiz.service.impl;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.repository.api.NPCDao;
import com.ttrpg.quadraticwiz.service.api.NPCFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NPCServiceImpl implements com.ttrpg.quadraticwiz.service.api.NPCService {

    private final NPCDao npcDao;

    private final NPCFactory npcFactory;

    @Override
    public BaseNPC generateNPC(Systems npcSystem, String... tags) {
        BaseNPC npc = npcFactory.generateNPC(npcSystem, tags);
        npcDao.saveNPC(npc);

        return npc;
    }

    @Override
    public BaseNPC getNPCById(String id) {
        return npcDao.getNPCById(id);
    }
}
