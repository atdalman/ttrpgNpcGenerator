package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Size extends WeightedAttribute {

    @Id
    private String _id;
    private String name;
}
