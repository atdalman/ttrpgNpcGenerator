package osr.monsterGenerator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import osr.monsterGenerator.repository.AttributeDAO;

// Place to save and periodically update the chances of attributes occuring in Mongo
public class CumulativeAttributeWeights {

    @Autowired
    private AttributeDAO attributeDAO;
    
    @Scheduled(fixedRate = 36000L)
    private void UpdateWeights() {
        SizeWeights = attributeDAO.getWeightByCollection("size");
    }
}
