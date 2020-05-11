package osr.monsterGenerator.npcAttributes;

import java.util.concurrent.ThreadLocalRandom;

public enum BodyCharacteristics {
    ;

    public static String selectRandomBodyCharacteristic() {
        int randNum = ThreadLocalRandom.current().nextInt(1, BodyCharacteristics.values().length+1);

        return BodyCharacteristics.values()[randNum].toString();

    }
}
