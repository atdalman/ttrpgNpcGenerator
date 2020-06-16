package osr.monsterGenerator.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BodyShape {
    @Id
    private String id;
    private String name;
    private String description;

}
