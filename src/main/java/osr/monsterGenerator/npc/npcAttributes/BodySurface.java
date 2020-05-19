package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class BodySurface {

    @Id
    private String id;
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
