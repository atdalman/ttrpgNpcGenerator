package osr.monsterGenerator.model.npc.npcAttributes;

import osr.monsterGenerator.utilities.RandomUtils;

public enum Alignments {

    CHAOTIC("Chaotic"),
    NEUTRAL("Neutral"),
    LAWFUL("Lawful"),
    NONE("None");

    private String alignment;

    Alignments(String alignment){
            this.alignment = alignment;
    }

    public String toString(){
        return this.alignment;
    }

    public static String selectRandomAlignment() {
        int randNum = RandomUtils.getRandomIntWithUpperBound(Alignments.values().length);

        return Alignments.values()[randNum].toString();
    }

}