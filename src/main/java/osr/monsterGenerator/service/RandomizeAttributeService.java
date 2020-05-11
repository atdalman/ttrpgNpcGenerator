package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.npcAttributes.Alignments;
import osr.monsterGenerator.npcAttributes.BodyShape;
import osr.monsterGenerator.npcAttributes.Sizes;
import osr.monsterGenerator.utilities.*;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomizeAttributeService {

    public String getRandomAlignment() {
        return Alignments.selectRandomAlignment();
    }

    public String getRandomProperName(int speciesType) {
        return "PHILBERT PENNYBOTTOMS";
    }

    public String getRandomName() {
        return "THE NEW GUY";
    }

    public String healthPoints() {
        return "666";
    }

    public static String getRandomSize() {
        return Sizes.getRandomSize();
    }

    public static String getRandomBodyCharacteristics() {
        return "BODY CHARACTERISTIC";
    }

    public static String getRandomMovementStyle() {
        return "MOVEMENTS";
    }

    public static String getRandomMovementSpeed() {
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

    public String getGeneralBodyShape() {
        return BodyShape.selectRandomBodyShape();
    }

    // TODO Determine good average ranges.  Weight ranges might be a good idea?
    public int getHitDie(Systems system) {

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
