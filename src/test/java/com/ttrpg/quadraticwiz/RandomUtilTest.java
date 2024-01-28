package com.ttrpg.quadraticwiz;

import org.junit.Assert;
import org.junit.Test;
import com.ttrpg.quadraticwiz.utilities.RandomUtils;

public class RandomUtilTest {

    @Test
    public void rollDice_noDice_IllegalArgumentExcTest() {
        try {
            RandomUtils.rollDice(0, 4);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        Assert.assertFalse(false);

    }

    @Test
    public void rollDice_diceSizeLessThanTwo_IllegalArgumentExcTest() {
        try {
            RandomUtils.rollDice(2, 1);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        Assert.assertFalse(false);

    }

    @Test
    public void rollDiceTest() {
        int count = 500, total = 0;

        do {
            total = RandomUtils.rollDice(6, 10);
            if (total < 6) Assert.assertTrue(false);
            count--;
        } while (count > 0);

        Assert.assertTrue(true);
    }

}
