package osr.monsterGenerator.npcAttributes;

import java.util.concurrent.ThreadLocalRandom;

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
        int randNum = ThreadLocalRandom.current().nextInt(1, Alignments.values().length+1);

        return Alignments.values()[randNum].toString();
    }

}