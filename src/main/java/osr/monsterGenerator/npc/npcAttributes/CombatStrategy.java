package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class CombatStrategy {

    @Id
    private String id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
