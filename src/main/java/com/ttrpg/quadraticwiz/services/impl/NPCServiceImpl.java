package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.repositories.api.NpcRepository;
import com.ttrpg.quadraticwiz.services.api.NpcFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements com.ttrpg.quadraticwiz.services.api.NpcService {

    private final NpcRepository npcRepository;

    private final NpcFactory npcFactory;

    @Override
    public BaseNpcEntity generateNpc(Systems npcSystem, String... tags) {
        BaseNpcEntity npc = npcFactory.generateNpc(npcSystem, tags);
        npcRepository.saveNpc(npc);

        return npc;
    }

    @Override
    public BaseNpcEntity getNpcById(String id) {
        return npcRepository.getNpcById(id);
    }
}
