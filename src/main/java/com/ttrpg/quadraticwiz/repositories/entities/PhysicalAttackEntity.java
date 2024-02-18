package com.ttrpg.quadraticwiz.repositories.entities;

import lombok.Data;

@Data
public class PhysicalAttackEntity extends NpcAttributeEntity {

    private int flatDamage; // average damage
    private int damageRoll; // d4/d6/etc
    private String specialEffect;

}
