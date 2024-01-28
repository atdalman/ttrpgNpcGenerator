package com.ttrpg.quadraticwiz.service.impl;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.repository.api.NPCRepository;
import com.ttrpg.quadraticwiz.service.api.NPCFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NPCServiceImpl implements com.ttrpg.quadraticwiz.service.api.NPCService {

    private final NPCRepository npcRepository;

    private final NPCFactory npcFactory;

    @Override
    public BaseNPC generateNPC(Systems npcSystem, String... tags) {
        BaseNPC npc = npcFactory.generateNPC(npcSystem, tags);
        npcRepository.saveNPC(npc);

        return npc;
    }

    @Override
    public BaseNPC getNPCById(String id) {
        return npcRepository.getNPCById(id);
    }
}
