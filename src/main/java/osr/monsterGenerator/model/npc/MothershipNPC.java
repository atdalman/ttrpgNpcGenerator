package osr.monsterGenerator.model.npc;

import lombok.Data;

@Data
public class MothershipNPC extends BaseNPC {
    public int instinct;
    public int combat;
    // Used for mercenaries
    public int loyalty;

}
