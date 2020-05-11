package osr.monsterGenerator.npcAttributes;

import osr.monsterGenerator.service.AttributeService;

import java.util.concurrent.ThreadLocalRandom;

public enum BodySurfaceCharacteristics {
    SLIMY,
    SMOOTH,
    RUBBERY,
    SANDPAPER,
    FLICKERY,
    GELATINOUS,
    SCALED,
    EXOSKELETON;

    public static String selectRandomBodyCharacteristic() {
        int randNum = AttributeService.getRandomNum(BodySurfaceCharacteristics.values().length);;

        return BodySurfaceCharacteristics.values()[randNum].toString();

    }
}
