package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.service.AttributeService;
import osr.monsterGenerator.utilities.WeightedItemList;

import java.util.HashMap;
import java.util.Map;

public class AttributeServiceTest {

    @Autowired
    AttributeService attributeService;

    // TODO Create mock db to use this properly
    public void tempRandomWeightedAttributeTest() {
        HashMap<String, Integer> totals = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Size curr = attributeService.getSize();
            if (totals.containsKey(curr.getName())) {
                totals.put(curr.getName(), totals.get(curr.getName()) + 1);
            } else {
                totals.put(curr.getName(), 1);
            }
        }

        System.out.println("Totals: " + totals.toString());
    }

    // TODO Don't think I'll be using this structure anymore, but keeping for the time being.
    @Test
    public void randomWeightedItemListAttributeTest() {
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

    @Test
    public void generateCombatAttr_combatOver100_return_100() {
        Assert.assertEquals(100, AttributeService.generateCombatAttr(200));
    }

    @Test
    public void generateCombatAttr_combatUnder0_return_0() {
        Assert.assertEquals(0, AttributeService.generateCombatAttr(-200));
    }
}
