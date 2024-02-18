package com.ttrpg.quadraticwiz.repositories.entities;

import com.ttrpg.quadraticwiz.domain.npc.enums.Alignments;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
public class DndNpcEntity extends BaseNpcEntity {
    private String alignment;
    private int armorClass;
    private String hitDie;
    private NpcAttributeEntity[] savingThrows;
    private String morale;

    public DndNpcEntity() {
        super();
        alignment = Alignments.NEUTRAL.name();
        armorClass = 10;
        hitDie = "2";
    }
}
