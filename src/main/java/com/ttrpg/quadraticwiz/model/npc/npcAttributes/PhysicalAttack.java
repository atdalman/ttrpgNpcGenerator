package com.ttrpg.quadraticwiz.model.npc.npcAttributes;

import lombok.Data;

@Data
public class PhysicalAttack extends NpcAttribute {

    private int flatDamage; // average damage
    private int damageRoll; // d4/d6/etc
    private String specialEffect;

}
