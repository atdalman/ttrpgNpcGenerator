package ttrpg.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"_id", "chance", "chanceSum"})
public abstract class WeightedAttribute {

    @Id
    private String _id;
    private double chance;
    private double chanceSum;

    public WeightedAttribute() {
        this.chance = 1.0;
        this.chanceSum = 0.0;
    }
}
