package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import osr.monsterGenerator.npc.npcAttributes.BodySurface;
import osr.monsterGenerator.npc.npcAttributes.Sizes;
import osr.monsterGenerator.service.AttributeService;

import java.util.HashMap;
import java.util.Map;

public class RandomAttributeServiceTest {

    @Test
    public void randomNumTest(){
        int cur, testLen = 1000;

        for(int i = 0; i < testLen; i++) {
            cur = AttributeService.getRandomNum(20);
            System.out.println(cur);
            if(cur < 0 || cur > testLen){
                Assert.assertTrue(false);
            }
        }

        Assert.assertTrue(true);
    }

    /*
        Roughly tests if sizes of different weights are chosen at greater frequencies than others.  Hard to test for
        randomness, so make sure the counts below are accurate expectations if the test starts failing
     */
    @Test
    public void randomSizeTest() {
        Sizes.createSizeList();
        Map<BodySurface, Integer> sizeCounts = new HashMap<>();
        BodySurface currSize;
        boolean passed = false;

        for (int i = 0; i < 1000; i++) {
            currSize = AttributeService.getSize();
            System.out.println(currSize);
            if (sizeCounts.containsKey(currSize)) sizeCounts.replace(currSize, sizeCounts.get(currSize) + 1);
            else sizeCounts.put(currSize, 1);
        }

        if (sizeCounts.get(Sizes.MEDIUM.name()) > 50 && sizeCounts.get(Sizes.GARGANTUAN.name()) < 15) passed = true;
        else passed = false;

        Assert.assertTrue(passed);

    }
}
