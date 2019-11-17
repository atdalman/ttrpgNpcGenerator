package osr.monsterGenerator.mechanicalProperties;

public enum Alignment {

    CHAOTIC("Chaotic"),
    NEUTRAL("Neutral"),
    LAWFUL("Lawful");

    private String alignment;

    Alignment(String alignment){
            this.alignment = alignment;
    }

    public String toString(){
        return this.alignment;
    }

    public static String selectRandomAlignment() {
        int numAlignments = Alignment.values().length;
        int randNum =  (int) ((Math.random() * (numAlignments + 1)) + 1);
        String alignment = Alignment.NEUTRAL.toString();
        switch (randNum) {
            case 1:
                alignment= Alignment.CHAOTIC.toString();
                break;
            case 2:
                alignment= Alignment.NEUTRAL.toString();
                break;
            case 3:
                alignment= Alignment.LAWFUL.toString();
                break;
        }
        return alignment;
    }

}