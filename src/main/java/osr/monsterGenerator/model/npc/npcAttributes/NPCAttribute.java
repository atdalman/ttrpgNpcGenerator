package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import osr.monsterGenerator.utilities.StringUtils;

@Data
public class NPCAttribute {

    private String briefDescription;
    private String verboseDescription;
    private int value;

    public String getDescription() {
        if (!StringUtils.isStringNullOrBlank(briefDescription))
            return briefDescription;
        else
            return verboseDescription;
    }

    public String getDescriptionByType(int descriptionType) {
        if (descriptionType == 1) return briefDescription;
        else if (descriptionType == 2) return verboseDescription;
        else return getDescription();
    }
}
