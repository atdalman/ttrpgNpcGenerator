package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.service.AttributeService;
import osr.monsterGenerator.npcAttributes.Sizes;

import java.util.HashMap;
import java.util.Map;

public class RandomAttributeServiceTest {

    @Autowired
    private AttributeService ras;

    /*
        Roughly tests if sizes of different weights are chosen at greater frequencies than others.  Hard to test for
        randomness, so make sure the counts below are accurate expectations if the test starts failing
     */
    @Test
    public void randomSizeTest(){
        Sizes.createSizeList();
        Map<String, Integer> sizeCounts = new HashMap<>();
        String currSize;
        boolean passed = false;

        for(int i = 0; i < 1000; i++){
            currSize = ras.getSize();
            System.out.println(currSize);
            if(sizeCounts.containsKey(currSize)) sizeCounts.replace(currSize, sizeCounts.get(currSize)+1);
            else sizeCounts.put(currSize, 1);
        }

        if(sizeCounts.get(Sizes.MEDIUM.name()) > 50 && sizeCounts.get(Sizes.GARGANTUAN.name()) < 15) passed = true;
        else passed = false;

        Assert.assertTrue(passed);

    }
}
