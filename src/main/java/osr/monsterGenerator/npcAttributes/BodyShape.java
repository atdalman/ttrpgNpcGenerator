package osr.monsterGenerator.npcAttributes;

import osr.monsterGenerator.service.AttributeService;

// TODO Move to Mongo
public enum BodyShape {
    CIRCULAR,
    SQUARE,
    BIPEDAL,
    HEXAGONAL,
    OCTAGONAL,
    CYLINDRICAL,
    AMORPHOUSMASS,
    AVIAN,
    SERPENTINE,
    UNKNOWABLE;

    public static String selectRandomBodyShape() {
        int randNum = AttributeService.getRandomNum(BodyShape.values().length);

        return BodyShape.values()[randNum].toString();
    }
}
