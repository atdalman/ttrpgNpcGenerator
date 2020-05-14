package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.npc.npcAttributes.*;
import osr.monsterGenerator.repository.DistinctiveFeatureRepository;
import osr.monsterGenerator.utilities.Systems;

import java.util.concurrent.ThreadLocalRandom;

public class AttributeService {

    @Autowired
    DistinctiveFeatureRepository disFeatRepo;

    public static int getRandomNum(int size) {
        return ThreadLocalRandom.current().nextInt(0, size + 1);
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

    public static Movement getMovement() {
        return new Movement();
    }

    public String getDistinctiveFeatures() {
        disFeatRepo.findAll().get(getRandomNum(disFeatRepo.size()));
        return disFeatRepo.findDistinctiveFeatureByName();
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
