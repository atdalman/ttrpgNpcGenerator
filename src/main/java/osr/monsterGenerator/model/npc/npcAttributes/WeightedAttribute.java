package osr.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class WeightedAttribute {
    @Id
    @JsonIgnore
    private String _id;
    @JsonIgnore
    private double chance;
    @JsonIgnore
    private double chanceSum;

    public WeightedAttribute() {
        this.chance = 1.0;
        this.chanceSum = 0.0;
    }
}
