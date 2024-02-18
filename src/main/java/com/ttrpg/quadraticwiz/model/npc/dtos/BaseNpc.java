package com.ttrpg.quadraticwiz.model.npc.dtos;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Movement;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NpcAttribute;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
// A basic monster or Npc
public class BaseNpc {
    private final String _id;
    private final String species;
    private final String properName;
    private final Size size;
    private final int experienceGiven;
    private final NpcAttribute bodyShape;
    private final NpcAttribute bodySurface;
    private final Movement movement;
    private final NpcAttribute peculiarCharacteristic;
    private final List<NpcAttribute> physicalAttacks;
    private final List<String> specialAbilities;
    private final List<NpcAttribute> combatStrategies;
    private final List<NpcAttribute> motivations;
}
