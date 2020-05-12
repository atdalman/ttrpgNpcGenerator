package osr.monsterGenerator.npc.npcAttributes;

import osr.monsterGenerator.service.AttributeService;

//TODO Move to Mongo
public enum BodySurfaceCharacteristics {
    SLIMY,
    SMOOTH,
    RUBBERY,
    SANDPAPER,
    FLICKERY,
    GELATINOUS,
    SCALED,
    EXOSKELETON,
    FEATHERED,
    HUMANESQUE,
    BONY,
    FURRY,
    FUZZY,
    CITRUSPEELESQUE,
    METALLIC,
    CRYSTAL;

    public static String selectRandomBodyCharacteristic() {
        int randNum = AttributeService.getRandomNum(BodySurfaceCharacteristics.values().length);

        return BodySurfaceCharacteristics.values()[randNum].toString();

    }
}
