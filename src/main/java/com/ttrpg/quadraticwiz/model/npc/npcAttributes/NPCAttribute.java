package com.ttrpg.quadraticwiz.model.npc.npcAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ttrpg.quadraticwiz.utilities.StringUtils;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"_id", "value", "tags"})
public class NPCAttribute {

    @Id
    private String _id;
    private String briefDescription;
    private String verboseDescription;
    private int value;
    private List<String> tags;

    @JsonIgnore
    public String getDescription() {
        if (!StringUtils.isStringNullOrBlank(briefDescription))
            return briefDescription;
        else
            return verboseDescription;
    }

    public String getDescription(int descriptionType) {
        if (descriptionType == 1) return briefDescription;
        else if (descriptionType == 2) return verboseDescription;
        else return getDescription();
    }
}

