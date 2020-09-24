package osr.monsterGenerator.utilities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomIntWithUpperBound(int size) {
        return ThreadLocalRandom.current().nextInt(0, size + 1);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static int rollDice(int numDice, int diceSize) {
        if (numDice < 1) throw new IllegalArgumentException("Need at least one dice to roll.");
        if (diceSize < 2) throw new IllegalArgumentException("Dice need at least 2 sides.");

        int total = 0;

        do {
            total += getRandomIntWithUpperBound(diceSize);
            numDice--;
        } while (numDice > 0);

        return total;
    }
}
