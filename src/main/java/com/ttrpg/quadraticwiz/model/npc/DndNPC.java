package com.ttrpg.quadraticwiz.model.npc;

import com.ttrpg.quadraticwiz.model.npc.npcAttributes.Alignments;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.NPCAttribute;
import lombok.Data;

@Data
public class DndNPC extends BaseNPC {
    private String alignment;
    private int armorClass;
    private String hitDie;
    private NPCAttribute[] savingThrows;
    private String morale;

    public DndNPC() {
        alignment = Alignments.NEUTRAL.name();
        armorClass = 10;
        hitDie = "2";
    }
}
