package com.ttrpg.quadraticwiz.domain.npc.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Size extends WeightedAttribute {
    private String briefDescription;
    @JsonIgnore
    private int moshMod;  // Used for shifting combat capabilities up or down based on size
    @JsonIgnore
    private int moshHitDie;
}