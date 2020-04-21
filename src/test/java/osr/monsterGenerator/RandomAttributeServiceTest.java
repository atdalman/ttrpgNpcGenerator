package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.service.RandomizeAttributeService;
import osr.monsterGenerator.utilities.Sizes;

import java.util.HashMap;
import java.util.Map;

public class RandomAttributeServiceTest {

    @Autowired
    private RandomizeAttributeService ras;

    @Test
    public void randomSizeTest(){
        Sizes.createSizeList();
        Map<String, Integer> sizeCounts = new HashMap<>();
        String currSize;
        boolean passed = false;

        for(int i = 0; i < 1000; i++){
            currSize = ras.getRandomSize();
            if(sizeCounts.containsKey(currSize)) sizeCounts.replace(currSize, sizeCounts.get(currSize)+1);
            else sizeCounts.put(currSize, 1);
        }

        if(sizeCounts.get("Medium") > 50 && sizeCounts.get("Gargantuan") < 15) passed = true;
        else passed = false;

        Assert.assertTrue(passed);

    }
}
