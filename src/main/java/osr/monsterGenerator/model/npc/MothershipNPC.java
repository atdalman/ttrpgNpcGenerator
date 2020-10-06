package osr.monsterGenerator.model.npc;

import lombok.Data;

@Data
public class MothershipNPC extends BaseNPC {
    public int instinct; // 0-99
    public int combat; // 0-99
    public int loyalty; // 0-99. Used for mercenaries
    public int hits;

}
