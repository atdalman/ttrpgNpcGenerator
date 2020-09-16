package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;

@Data
public abstract class WeightedAttribute {
    private double chance = 1;
    private double chanceSum = 0;
}
