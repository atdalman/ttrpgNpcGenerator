package com.ttrpg.quadraticwiz.repository.api;

import com.ttrpg.quadraticwiz.model.npc.BaseNPC;

public interface NPCDao {
    BaseNPC getNPCById(String id);

    String saveNPC(BaseNPC npc);

    void removeOldNpcs();
}
