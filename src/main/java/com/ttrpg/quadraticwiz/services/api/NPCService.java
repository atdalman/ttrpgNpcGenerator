package com.ttrpg.quadraticwiz.services.api;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;

public interface NpcService {
    BaseNpcEntity generateNpc(Systems npcSystem, String... tags);

    BaseNpcEntity getNpcById(String id);
}
