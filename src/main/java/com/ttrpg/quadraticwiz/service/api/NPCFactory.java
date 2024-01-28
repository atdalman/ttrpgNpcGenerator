package com.ttrpg.quadraticwiz.service.api;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.BaseNPC;
import com.ttrpg.quadraticwiz.model.npc.MothershipNPC;

import java.util.List;

public interface NPCFactory {
    BaseNPC generateNPC(Systems npcType, String... tagArr);

    BaseNPC generateBaseNPC(List<String> tags);

    MothershipNPC generateMoshNPC(List<String> tags);

    // TODO Finish
    BaseNPC generateDndPC(List<String> tags);

    // TODO Finish
    BaseNPC generateOSRNPC(List<String> tags);
}
