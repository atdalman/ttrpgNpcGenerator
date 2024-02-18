package com.ttrpg.quadraticwiz.domain.npc.dtos;

import lombok.Data;

@Data
public class PhysicalAttack extends NpcAttribute {

    private int flatDamage; // average damage
    private int damageRoll; // d4/d6/etc
    private String specialEffect;

}
