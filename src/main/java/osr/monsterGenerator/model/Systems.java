package osr.monsterGenerator.model;

public enum Systems {

    ASSH("Astonishing Swordsmen & Sorcerers of Hyperborea"),
    MOTHERSHIP("Mothership"),
    DND5E("Dungeons & Dragons, 5th Edition"),
    OSROTHER("Other"), //OSR-compatible stats
    BASE("Base"); //Descriptions and motives only

    public final String label;

    private Systems(String label) {
        this.label = label;
    }

}