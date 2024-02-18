package com.ttrpg.quadraticwiz.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonIgnoreProperties({"_id", "chance", "chanceSum"})
public abstract class WeightedAttributeEntity {

    @Id
    private String _id;
    private double chance;
    private double chanceSum;

    public WeightedAttributeEntity() {
        this.chance = 1.0;
        this.chanceSum = 0.0;
    }
}
