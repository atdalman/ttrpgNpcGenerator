package osr.monsterGenerator.mechanicProperties;

enum Alignment {

    CHAOTIC("Chaotic"),
    NEUTRAL("Neutral"),
    LAWFUL("Lawful");

    private String alignment;

    Alignment(String alignment){
            this.alignment = alignment;
    }

    public String getAlignment(){
        return this.alignment;
    }

}