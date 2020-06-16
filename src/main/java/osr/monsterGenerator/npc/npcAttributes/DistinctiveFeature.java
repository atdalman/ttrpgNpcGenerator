package osr.monsterGenerator.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DistinctiveFeature {

    @Id
    private String id;
    private String description;

    public String toString() {
        return "DistinctiveFeature{" +
                ", description='" + description + '\'' +
                '}';
    }
}
