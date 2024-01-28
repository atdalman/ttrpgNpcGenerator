package com.ttrpg.quadraticwiz.services.api;

import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.model.npc.npcAttributes.*;
import com.ttrpg.quadraticwiz.repositories.MongoCollection;
import com.ttrpg.quadraticwiz.utilities.RandomUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public interface AttributeService {
    static String getAlignment() {
        return Alignments.selectRandomAlignment();
    }

    static String getProperName(int speciesType) {
        return "PHILBERT PENNYBOTTOMS";
    }

    static String getSpecies() {
        return "SEQUIA SEMPERVIRENS";
    }

    static int generateHealthPoints(int numDice, int diceSize, int mod) {
        return RandomUtils.rollDice(numDice, diceSize) + mod;
    }

    // TODO Determine good average ranges.  Weight ranges might be a good idea?
    static int getHitDie(Systems system) {

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

    static int generateInstinctAttr() {
        return RandomUtils.rollDice(6, 10);
    }

    static int generateLoyaltyAttr() {
        return RandomUtils.rollDice(6, 10);
    }

    static int generateCombatAttr(int moshCombatMod) {
        int res = RandomUtils.rollDice(6, 10) + moshCombatMod;
        if (res > 99) res = 99;
        else if (res < 0) res = 0;
        return res;
    }

    static int generateHitsAttr(int diceSize) {
        return RandomUtils.rollDice(1, diceSize);
    }

    WeightedAttribute generateWeightedNPCAttribute(MongoCollection mongoCollection, List<String> tags);

    Size getSize(List<String> tags);

    NPCAttribute generateNPCAttribute(MongoCollection mongoCollection, List<String> tags);

    Movement getMovement(List<String> tags);

    List<NPCAttribute> getCombatStrategies();

    List<NPCAttribute> getMotivations();
}
