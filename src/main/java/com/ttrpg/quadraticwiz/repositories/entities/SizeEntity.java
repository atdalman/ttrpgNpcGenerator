package com.ttrpg.quadraticwiz.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SizeEntity extends WeightedAttributeEntity {
    private String briefDescription;
    @JsonIgnore
    private int moshMod;  // Used for shifting combat capabilities up or down based on size
    @JsonIgnore
    private int moshHitDie;
}