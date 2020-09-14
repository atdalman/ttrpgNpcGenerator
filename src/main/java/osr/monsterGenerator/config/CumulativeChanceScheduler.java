package osr.monsterGenerator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import osr.monsterGenerator.repository.AttributeDAO;

// Place to save and periodically update the chances of attributes occuring in Mongo
@Slf4j
public class CumulativeChanceScheduler {


    @Autowired
    private AttributeDAO attributeDAO;

    @Scheduled(fixedRate = 36000L)
    private void UpdateWeights() {
        attributeDAO.updateCumulativeByCollection("size");

    }
}
