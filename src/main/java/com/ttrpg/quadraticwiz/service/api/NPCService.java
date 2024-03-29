package com.ttrpg.quadraticwiz.service.api;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;

public interface NPCService {
    BaseNPC generateNPC(Systems npcSystem, String... tags);

    BaseNPC getNPCById(String id);
}
