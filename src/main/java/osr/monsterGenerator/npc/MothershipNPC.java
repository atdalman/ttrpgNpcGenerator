package osr.monsterGenerator.npc;

import lombok.Data;

@Data
public class MothershipNPC extends BaseNPC {
    public String instinct;
    public String combat;
    // Used for mercenaries
    public String loyalty;

}
