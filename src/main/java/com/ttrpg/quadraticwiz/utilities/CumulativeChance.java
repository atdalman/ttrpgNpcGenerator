package com.ttrpg.quadraticwiz.utilities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CumulativeChance {
    private double cumulativeChance = 0.0;
    private String attribute;
    private LocalDateTime updateDate;
}
