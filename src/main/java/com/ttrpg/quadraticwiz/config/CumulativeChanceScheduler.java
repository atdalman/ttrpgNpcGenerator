package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repository.AttributeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

// Place to save and periodically update the chances of attributes occuring in Mongo
@EnableScheduling
@Configuration
public class CumulativeChanceScheduler {

    @Autowired
    AttributeDAO attributeDAO;

    // 10 minutes
    @Scheduled(fixedRate = 600000L)
    private void updateCumulativeChances() {
        System.out.println("Running chance scheduler...");
        attributeDAO.updateChances("size");
    }
}
