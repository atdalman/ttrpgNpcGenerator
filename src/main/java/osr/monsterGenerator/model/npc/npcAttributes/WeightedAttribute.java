package osr.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public abstract class WeightedAttribute {
    @JsonIgnore
    private double chance = 1;
    @JsonIgnore
    private double chanceSum = 0;
}
