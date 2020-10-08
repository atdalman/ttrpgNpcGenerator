package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;

@Data
public abstract class NPCAttribute {

    private String briefDescription;
    private String verboseDescription;

    public String getDescription() {
        return briefDescription;
    }

    public String getDescriptionByType(int descriptionType) {
        if (descriptionType == 1) return briefDescription;
        else if (descriptionType == 2) return verboseDescription;
        else return getDescription();
    }
}
