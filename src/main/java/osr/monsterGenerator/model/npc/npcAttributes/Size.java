package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;

@Data
public class Size extends WeightedAttribute {
    private String name;
    private int sizeFactor;
}