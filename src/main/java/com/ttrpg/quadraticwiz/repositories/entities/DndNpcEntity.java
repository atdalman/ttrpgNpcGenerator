package com.ttrpg.quadraticwiz.repositories.entities;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Alignments;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NpcAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class DndNpcEntity extends BaseNpcEntity {
    private String alignment;
    private int armorClass;
    private String hitDie;
    private NpcAttribute[] savingThrows;
    private String morale;

    public DndNpcEntity() {
        super();
        alignment = Alignments.NEUTRAL.name();
        armorClass = 10;
        hitDie = "2";
    }
}
