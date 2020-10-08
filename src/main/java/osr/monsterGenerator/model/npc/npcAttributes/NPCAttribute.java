package osr.monsterGenerator.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import osr.monsterGenerator.utilities.StringUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NPCAttribute {

    private String briefDescription;
    private String verboseDescription;
    private int value;
    private String[] tags;

    @JsonIgnore
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

