package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class DistinctiveFeature {

    @Id
    private String name;
    private String description;

    public DistinctiveFeature() {
        name = "test3";
        description = "test4";
    }

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

    @Override
    public String toString() {
        return "DistinctiveFeature{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
