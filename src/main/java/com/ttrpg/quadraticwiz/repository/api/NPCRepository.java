package com.ttrpg.quadraticwiz.repository.api;

import com.ttrpg.quadraticwiz.model.npc.BaseNPC;

public interface NPCRepository {
    BaseNPC getNPCById(String id);

    String saveNPC(BaseNPC npc);

    void removeOldNpcs();
}
