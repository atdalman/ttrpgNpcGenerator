package com.ttrpg.quadraticwiz.domain.npc.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class MothershipNpc extends BaseNpc {
    private int instinct; // 0-99
    private int combat; // 0-99
    private int loyalty; // 0-99. Used for mercenaries
    private String hits;
}