package osr.monsterGenerator.model.npc;

import lombok.Data;

@Data
public class MothershipNPC extends BaseNPC {
    private int instinct; // 0-99
    private int combat; // 0-99
    private int loyalty; // 0-99. Used for mercenaries
    private String hits;
}
