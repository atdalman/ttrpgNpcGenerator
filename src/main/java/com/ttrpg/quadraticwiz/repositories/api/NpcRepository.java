package com.ttrpg.quadraticwiz.repositories.api;

import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;

public interface NpcRepository {
    BaseNpcEntity getNpcById(String id);

    String saveNpc(BaseNpcEntity npc);

    void removeOldNpcs();
}
