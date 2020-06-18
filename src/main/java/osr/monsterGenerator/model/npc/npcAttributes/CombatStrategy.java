package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CombatStrategy {

    @Id
    private String id;
    private String description;

}
