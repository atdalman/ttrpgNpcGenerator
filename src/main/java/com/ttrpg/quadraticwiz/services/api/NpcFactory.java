package com.ttrpg.quadraticwiz.services.api;

import com.ttrpg.quadraticwiz.domain.Systems;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.repositories.entities.MothershipNpcEntity;

import java.util.List;

public interface NpcFactory {
    BaseNpcEntity generateNpc(Systems npcType, String... tagArr);

    BaseNpcEntity generateBaseNpc(List<String> tags);

    MothershipNpcEntity generateMoshNpc(List<String> tags);

    // TODO Finish
    BaseNpcEntity generateDndPC(List<String> tags);

    // TODO Finish
    BaseNpcEntity generateOSRNpc(List<String> tags);
}
