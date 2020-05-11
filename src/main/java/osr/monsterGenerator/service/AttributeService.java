package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.npcAttributes.Alignments;
import osr.monsterGenerator.npcAttributes.BodyShape;
import osr.monsterGenerator.npcAttributes.BodySurfaceCharacteristics;
import osr.monsterGenerator.npcAttributes.Sizes;
import osr.monsterGenerator.utilities.*;

import java.util.concurrent.ThreadLocalRandom;

public class AttributeService {

    public static int getRandomNum(int size){
        return ThreadLocalRandom.current().nextInt(0, size+1);
    }

    public static String getAlignment() {
        return Alignments.selectRandomAlignment();
    }

    public static String getProperName(int speciesType) {
        return "PHILBERT PENNYBOTTOMS";
    }

    public static String getName() {
        return "THE NEW GUY";
    }

    public static String healthPoints() {
        return "666";
    }

    public static String getSize() {
        return Sizes.getRandomSize();
    }

    public static String getBodySurfaceCharacteristics() {
        return BodySurfaceCharacteristics.selectRandomBodyCharacteristic();
    }

    public static String getMovementStyle() {
        return "MOVEMENTS";
    }

    public static String getMovementSpeed() {
        return "SO FAST";
    }

    public static String getDistinctiveFeatures() {
        return "MOVEMENTS";
    }

    public static String getCombatStrategy() {
        return "DODGE, DUCK, DIP, DIVE, and DODGE";
    }

    public static String[] getMotivations() {
        return new String[]{"FOOD", "SURVIVAL"};
    }

    public static String getGeneralBodyShape() {
        return BodyShape.selectRandomBodyShape();
    }

    public static int getNumLimbs(){ return 6;}

    // TODO Determine good average ranges.  Weight ranges might be a good idea?
    public static int getHitDie(Systems system) {

        switch (system) {
            case ASSH:
                return ThreadLocalRandom.current().nextInt(1, 5);
            case DND5E:
                return ThreadLocalRandom.current().nextInt(1, 5);
            case OSROTHER:
                return ThreadLocalRandom.current().nextInt(1, 5);
            default:
                return ThreadLocalRandom.current().nextInt(1, 5);

        }
    }
}
