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
        int numAlignments = Alignments.values().length;
        int randNum =  ThreadLocalRandom.current().nextInt(1, numAlignments + 1);
        String alignment;
        switch (randNum) {
            case 1:
                alignment= Alignments.CHAOTIC.toString();
                break;
            case 2:
                alignment= Alignments.NEUTRAL.toString();
                break;
            case 3:
                alignment= Alignments.LAWFUL.toString();
                break;
            default:
                alignment = Alignments.NONE.toString();
        }
        return alignment;
    }

}