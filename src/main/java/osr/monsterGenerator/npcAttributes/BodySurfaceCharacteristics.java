package osr.monsterGenerator.npcAttributes;

import java.util.concurrent.ThreadLocalRandom;

public enum BodySurfaceCharacteristics {
    SLIMY,
    SMOOTH,
    RUBBERY,
    SANDPAPER,
    FLICKERY,
    GELATINOUS,
    SCALED,
    ;

    public static String selectRandomBodyCharacteristic() {
        int randNum = ThreadLocalRandom.current().nextInt(1, BodySurfaceCharacteristics.values().length+1);

        return BodySurfaceCharacteristics.values()[randNum].toString();

    }
}
