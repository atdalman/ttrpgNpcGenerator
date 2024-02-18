package com.ttrpg.quadraticwiz.services.api;

import com.ttrpg.quadraticwiz.domain.Systems;
import com.ttrpg.quadraticwiz.domain.npc.dtos.BaseNpc;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;

import java.util.UUID;

public interface NpcService {
    BaseNpcEntity generateNpc(Systems npcSystem, String... tags);

    BaseNpc getNpcById(UUID npcId);
}
