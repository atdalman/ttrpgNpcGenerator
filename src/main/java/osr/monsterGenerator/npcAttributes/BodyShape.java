package osr.monsterGenerator.npcAttributes;

import java.util.concurrent.ThreadLocalRandom;

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
        int randNum = ThreadLocalRandom.current().nextInt(1, BodyShape.values().length+1);

        return BodyShape.values()[randNum].toString();
    }
}
