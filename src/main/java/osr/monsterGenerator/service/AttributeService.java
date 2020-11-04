package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.npcAttributes.*;
import osr.monsterGenerator.repository.AttributeDAO;
import osr.monsterGenerator.repository.MongoCollection;
import osr.monsterGenerator.utilities.RandomUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AttributeService {

    @Autowired
    AttributeDAO attributeDAO;

    public static String getAlignment() {
        return Alignments.selectRandomAlignment();
    }

    public static String getProperName(int speciesType) {
        return "PHILBERT PENNYBOTTOMS";
    }

    public static String getSpecies() {
        return "SEQUIA SEMPERVIRENS";
    }

    public static int generateHealthPoints(int numDice, int diceSize, int mod) {
        return RandomUtils.rollDice(numDice, diceSize) + mod;
    }

    public WeightedAttribute generateWeightedNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (WeightedAttribute) attributeDAO.getRandomWeightedNPCAttribute(mongoCollection.label, tags,
                WeightedAttribute.class);
    }

    public Size getSize(List<String> tags) {
        return (Size) attributeDAO.getRandomWeightedNPCAttribute(MongoCollection.SIZE.label, tags,
                Size.class);
    }

    public NPCAttribute generateNPCAttribute(MongoCollection mongoCollection, List<String> tags) {
        return (NPCAttribute) attributeDAO.getRandomNPCAttribute(mongoCollection.label, tags, NPCAttribute.class);
    }

    public Movement getMovement(List<String> tags) {
        return (Movement) attributeDAO.getRandomNPCAttribute(MongoCollection.MOVEMENT.label, tags, Movement.class);

    }

    public List<NPCAttribute> getCombatStrategies() {
        return attributeDAO.getMultipleAttributes(2, MongoCollection.COMBAT_STRATEGY.label);
    }

    public List<NPCAttribute> getMotivations() {
        return attributeDAO.getMultipleAttributes(2, MongoCollection.MOTIVATION.label);
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

    /**********Mothership**********/

    public static int generateInstinctAttr() {
        return RandomUtils.rollDice(6, 10);
    }

    public static int generateLoyaltyAttr() {
        return RandomUtils.rollDice(6, 10);
    }

    public static int generateCombatAttr(int moshCombatMod) {
        int res = RandomUtils.rollDice(6, 10) + moshCombatMod;
        if (res > 99) res = 99;
        else if (res < 0) res = 0;
        return res;
    }

    public static int generateHitsAttr(int diceSize) {
        return RandomUtils.rollDice(1, diceSize);
    }
}
