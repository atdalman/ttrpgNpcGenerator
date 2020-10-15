package osr.monsterGenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.npcAttributes.Alignments;
import osr.monsterGenerator.model.npc.npcAttributes.Movement;
import osr.monsterGenerator.model.npc.npcAttributes.NPCAttribute;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.repository.AttributeCollection;
import osr.monsterGenerator.repository.AttributeDAO;
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

    public Size getSize() {
        return (Size) attributeDAO.getSingleRandomAttributeUsingWeightedChance(Size.class.getSimpleName().toLowerCase());
    }

    public NPCAttribute generateNPCAttribute(AttributeCollection attributeCollection, String... tags) {
        return attributeDAO.getSingleRandomAttribute(attributeCollection.label, tags);
    }

    public Movement getMovement() {
        return attributeDAO.getRandomMovement();
    }

    public List<NPCAttribute> getCombatStrategies() {
        return attributeDAO.getMultipleAttributes(2, AttributeCollection.COMBAT_STRATEGY.label);
    }

    public List<NPCAttribute> getMotivations() {
        return attributeDAO.getMultipleAttributes(2, AttributeCollection.MOTIVATION.label);
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
