package com.ttrpg.quadraticwiz.repositories.api;

import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;

import java.util.UUID;

public interface NpcRepository {
    BaseNpcEntity getNpcById(UUID npcId);

    BaseNpcEntity saveNpc(BaseNpcEntity npc);

    void removeOldNpcs();
}
