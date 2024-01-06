package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repository.AttributeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

// Place to save and periodically update the chances of attributes occurring in Mongo
@EnableScheduling
@Configuration
@Slf4j
@RequiredArgsConstructor
public class CumulativeChanceScheduler {

    private final AttributeDAO attributeDAO;

    // 10 minutes
    @Scheduled(fixedRate = 600000L)
    private void updateCumulativeChances() {
        System.out.println("Running chance scheduler...");
        attributeDAO.updateChances("size");
    }
}
