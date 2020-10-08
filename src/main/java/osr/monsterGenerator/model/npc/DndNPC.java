package osr.monsterGenerator.model.npc;

import lombok.Data;
import osr.monsterGenerator.model.npc.npcAttributes.Alignments;
import osr.monsterGenerator.model.npc.npcAttributes.NPCAttribute;

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
