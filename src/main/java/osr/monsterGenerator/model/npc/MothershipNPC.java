package osr.monsterGenerator.model.npc;

import lombok.Data;

@Data
public class MothershipNPC extends BaseNPC {
    public int instinct; //0-100
    public int combat;
    public int loyalty; // Used for mercenaries

}
