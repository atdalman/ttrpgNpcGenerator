package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class Motivation {
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
