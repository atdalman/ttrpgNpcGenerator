package osr.monsterGenerator.service;

import osr.monsterGenerator.utilities.Alignments;
import osr.monsterGenerator.utilities.BodyShape;
import osr.monsterGenerator.utilities.Systems;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizeAttributesService {
//    private String name;
//    private String properName;
//    private String armorClass;
//    private int healthPoints;
//    private int hitDie;
//    private int experienceGiven;
//    private String generalBodyShape;
//    private String bodyCharacteristics;
//    private String size;
//    private String movementStyle;
//    private int movementSpeed;
//    private String distinctiveFeatures;
//    private PhysicalAttack[] physicalAttacks;
//    private String[] specialAbilities;
//    private String combatStrategyPrimary;
//    private String combatStrategySecondary;
//    private String motivation;
//    private SavingThrow[] savingThrows;
//    private String morale;

    public static String getRandomAlignment() {
        return Alignments.selectRandomAlignment();
    }

    public static String getRandomProperName(int speciesType) {
        //TODO Write generic humanoid name generator
        return null;
    }

    // TODO Determine good average ranges.  Weight ranges might be a good idea?
    public static int hitDie(Systems system){

        switch(system){
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

    public static String generalBodyShape() {
        return BodyShape.selectRandomBodyShape();
    }
}
