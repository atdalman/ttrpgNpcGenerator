package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;

@Data
public class PhysicalAttack {

    private String name; // claw/bite/strike
    private int flatDamage; // average damage
    private int damageRoll; // d4/d6/etc
    private String specialEffect;

}
