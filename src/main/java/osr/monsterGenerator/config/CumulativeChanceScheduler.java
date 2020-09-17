package osr.monsterGenerator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import osr.monsterGenerator.model.npc.npcAttributes.Size;
import osr.monsterGenerator.repository.AttributeDAO;

import java.util.HashMap;

// Place to save and periodically update the chances of attributes occuring in Mongo
@EnableScheduling
@Configuration
public class CumulativeChanceScheduler {


    @Autowired
    private AttributeDAO attributeDAO;

    @Scheduled(fixedRate = 600000L)
    private void updateCumulativeChances() {
        attributeDAO.updateChances("size");
        //tempRandomWeightedAttributeTest();
    }

    // TODO Create mock db to use this properly
    private void tempRandomWeightedAttributeTest() {
        HashMap<String, Integer> totals = new HashMap<>();
        for (int i = 0; i < 500; i++) {
            Size curr = attributeDAO.getSingleRandomAttributeUsingChance("size");
            if (totals.containsKey(curr.getName())) {
                totals.put(curr.getName(), totals.get(curr.getName()) + 1);
            } else {
                totals.put(curr.getName(), 0);
            }
        }

        System.out.println(totals.toString());
    }
}
