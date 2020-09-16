package osr.monsterGenerator.utilities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int getRandomInt(int size) {
        return ThreadLocalRandom.current().nextInt(0, size + 1);
    }

    public static double getRandomDouble(int size) {
        return ThreadLocalRandom.current().nextDouble();
    }
}
