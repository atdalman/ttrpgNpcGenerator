package com.ttrpg.quadraticwiz.repositories.entities;

import lombok.Data;

@Data
public class MothershipNpcEntity extends BaseNpcEntity {
    private int instinct; // 0-99
    private int combat; // 0-99
    private int loyalty; // 0-99. Used for mercenaries
    private String hits;
}