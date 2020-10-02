package osr.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Size extends WeightedAttribute {
    private String name;
    @JsonIgnore
    private int moshCombatMultiplier;  // Used for shifting combat capabilities up or down based on size
}