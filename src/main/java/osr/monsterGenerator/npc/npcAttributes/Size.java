package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class Size {
    @Id
    private String id;
    private String name;
    private double chance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }
}
