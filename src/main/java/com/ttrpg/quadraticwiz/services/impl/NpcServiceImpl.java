package com.ttrpg.quadraticwiz.services.impl;

import com.ttrpg.quadraticwiz.domain.Systems;
import com.ttrpg.quadraticwiz.domain.npc.dtos.BaseNpc;
import com.ttrpg.quadraticwiz.mappers.EntityMapper;
import com.ttrpg.quadraticwiz.repositories.api.NpcRepository;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.services.api.NpcFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NpcServiceImpl implements com.ttrpg.quadraticwiz.services.api.NpcService {

    private final NpcRepository npcRepository;

    private final NpcFactory npcFactory;

    private final EntityMapper entityMapper;

    @Override
    public BaseNpcEntity generateNpc(Systems npcSystem, String... tags) {
        BaseNpcEntity npc = npcFactory.generateNpc(npcSystem, tags);
        npcRepository.saveNpc(npc);

        return npc;
    }

    @Override
    public BaseNpc getNpcById(UUID npcId) {
        return entityMapper.toBaseNpc(npcRepository.getNpcById(npcId));
    }
}
