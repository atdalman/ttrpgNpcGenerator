package com.ttrpg.quadraticwiz.repositories.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class MothershipNpcEntity extends BaseNpcEntity {
    private int instinct; // 0-99
    private int combat; // 0-99
    private int loyalty; // 0-99. Used for mercenaries
    private String hits;
}