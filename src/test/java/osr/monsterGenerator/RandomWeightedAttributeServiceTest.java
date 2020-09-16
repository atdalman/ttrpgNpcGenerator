package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.repository.AttributeDAO;
import osr.monsterGenerator.service.AttributeService;
import osr.monsterGenerator.utilities.WeightedItemList;

import java.util.HashMap;
import java.util.Map;

public class RandomWeightedAttributeServiceTest {

    @Autowired
    AttributeDAO attributeDAO;

    @Test
    public void randomNumTest() {
        int cur, testLen = 1000;

        for (int i = 0; i < testLen; i++) {
            cur = AttributeService.getRandomInt(20);
            System.out.println(cur);
            if (cur < 0 || cur > testLen) {
                Assert.assertTrue(false);
            }
        }

        Assert.assertTrue(true);
    }

    @Test
    public void randomWeightedAttributeTest() {
        WeightedItemList list = new WeightedItemList();
        list.addEntry("Medium", 1);
        list.addEntry("Large", 1);
        list.addEntry("Small", 1);
        list.addEntry("Tiny", .25);
        list.addEntry("Swarm", .1);
        list.addEntry("Huge", .25);
        list.addEntry("Gargantuan", .1);
        list.addEntry("Galaxian", .01);

        Map<String, Integer> sizeCounts = new HashMap<>();
        String currSize;

        for (int i = 0; i < 1000; i++) {
            currSize = list.getRandom().toString();
            if (sizeCounts.containsKey(currSize)) sizeCounts.replace(currSize, sizeCounts.get(currSize) + 1);
            else sizeCounts.put(currSize, 1);
        }

        Boolean passed;

        if (sizeCounts.get("Medium") > 200 && sizeCounts.get("Gargantuan") < 50) passed = true;
        else passed = false;

        Assert.assertTrue(passed);

    }
}
