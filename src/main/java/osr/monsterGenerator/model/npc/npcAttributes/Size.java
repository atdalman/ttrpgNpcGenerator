package osr.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Size extends WeightedAttribute {

    @Id
    @JsonIgnore
    private String _id;
    private String name;
}
