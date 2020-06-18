package osr.monsterGenerator.model.npc;

import lombok.Data;
import osr.monsterGenerator.model.npc.npcAttributes.Alignments;
import osr.monsterGenerator.model.npc.npcAttributes.SavingThrow;

@Data
public class DndNPC extends BaseNPC {
    private String alignment;
    private int armorClass;
    private String hitDie;
    private SavingThrow[] savingThrows;
    private String morale;

    public DndNPC() {
        alignment = Alignments.NEUTRAL.name();
        armorClass = 10;
        hitDie = "2";
    }
}
