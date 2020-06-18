package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Size {
    @Id
    private String id;
    private String name;
    private double chance;

}
