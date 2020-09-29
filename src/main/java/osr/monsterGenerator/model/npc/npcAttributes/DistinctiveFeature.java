package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;

@Data
public class DistinctiveFeature {

    private String description;

    public String toString() {
        return "DistinctiveFeature{" +
                ", description='" + description + '\'' +
                '}';
    }
}
