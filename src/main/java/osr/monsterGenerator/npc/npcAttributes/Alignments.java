package osr.monsterGenerator.npc.npcAttributes;

import osr.monsterGenerator.service.AttributeService;

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

    // TODO Update to use random num method in AttributeService
    public static String selectRandomAlignment() {
        int randNum = AttributeService.getRandomNum(Alignments.values().length);

        return Alignments.values()[randNum].toString();
    }

}