package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class WeightedAttribute {
    @Id
    private String _id;
    private double chance = 1;
    private double chanceSum = 0;
}
