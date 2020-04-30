package osr.monsterGenerator.npc;

import osr.monsterGenerator.utilities.Alignments;
import osr.monsterGenerator.npcAttributes.SavingThrow;

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

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getHitDie() {
        return hitDie;
    }

    public void setHitDie(String hitDie) {
        this.hitDie = hitDie;
    }

    public SavingThrow[] getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrow[] savingThrows) {
        this.savingThrows = savingThrows;
    }

    public String getMorale() {
        return morale;
    }

    public void setMorale(String morale) {
        this.morale = morale;
    }
}
