package com.ttrpg.quadraticwiz;

import org.junit.Assert;
import org.junit.Test;
import com.ttrpg.quadraticwiz.service.api.AttributeService;
import com.ttrpg.quadraticwiz.utilities.WeightedItemList;

import java.util.HashMap;
import java.util.Map;

public class AttributeServiceTest {

//    @Autowired
//    AttributeService attributeService;
//
//    @Mock
//    private HelloRepository helloRepository;
//
//    @InjectMocks // auto inject helloRepository
//    private HelloService helloService = new HelloServiceImpl();
//
//    @BeforeEach
//    void setMockOutput() {
//        when(helloRepository.get()).thenReturn("Hello Mockito From Repository");
//    }
//
//    // TODO Create mock db to use this properly
//    @Test
//    public void tempRandomWeightedAttributeTest() {
//        HashMap<String, Integer> totals = new HashMap<>();
//        for (int i = 0; i < 100; i++) {
//            Size curr = attributeService.getSize();
//            if (totals.containsKey(curr.getBriefDescription())) {
//                totals.put(curr.getBriefDescription(), totals.get(curr.getBriefDescription()) + 1);
//            } else {
//                totals.put(curr.getBriefDescription(), 1);
//            }
//        }
//
//        System.out.println("Totals: " + totals.toString());
//    }

//    @Test
//    public void tempRandomWeightedAttributeTest() {
//        HashMap<String, Integer> totals = new HashMap<>();
//        for (int i = 0; i < 100; i++) {
//            Size curr = attributeService.getSize();
//            if (totals.containsKey(curr.getBriefDescription())) {
//                totals.put(curr.getBriefDescription(), totals.get(curr.getBriefDescription()) + 1);
//            } else {
//                totals.put(curr.getBriefDescription(), 1);
//            }
//        }
//
//        System.out.println("Totals: " + totals.toString());
//    }

    // TODO Don't think I'll be using this structure anymore, but keeping for demo purpose.
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

        passed = sizeCounts.get("Medium") > 200 && sizeCounts.get("Gargantuan") < 50;

        Assert.assertTrue(passed);

    }

    @Test
    public void generateCombatAttr_combatOver100_return100() {
        Assert.assertEquals(99, AttributeService.generateCombatAttr(200));
    }

    @Test
    public void generateCombatAttr_combatUnder0_return0() {
        Assert.assertEquals(0, AttributeService.generateCombatAttr(-200));
    }
}
