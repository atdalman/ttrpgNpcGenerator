package com.ttrpg.quadraticwiz.domain.npc.dtos;

import com.ttrpg.quadraticwiz.repositories.entities.MovementEntity;
import com.ttrpg.quadraticwiz.repositories.entities.NpcAttributeEntity;
import com.ttrpg.quadraticwiz.repositories.entities.SizeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
// A basic monster or Npc
public class BaseNpc {
    private UUID npcId;
    private String species;
    private String properName;
    private SizeEntity size;
    private int experienceGiven;
    private NpcAttributeEntity bodyShape;
    private NpcAttributeEntity bodySurface;
    private MovementEntity movement;
    private NpcAttributeEntity peculiarCharacteristic;
    private List<NpcAttributeEntity> physicalAttacks;
    private List<String> specialAbilities;
    private List<NpcAttributeEntity> combatStrategies;
    private List<NpcAttributeEntity> motivations;
}
