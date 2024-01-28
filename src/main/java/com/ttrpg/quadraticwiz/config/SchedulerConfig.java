package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repositories.api.AttributeRepository;
import com.ttrpg.quadraticwiz.repositories.api.NPCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

// Place to save and periodically update the chances of attributes occurring in Mongo
@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class SchedulerConfig {

    private final AttributeRepository attributeRepository;
    private final NPCRepository npcRepository;

    // 10 minutes
    @Scheduled(fixedRate = 600000L)
    private void updateCumulativeChances() {
        System.out.println("Running chance scheduler...");
        attributeRepository.updateChances("size");
    }

    @Scheduled(fixedRate = 43200000L)
    private void removeOldNPCs() {
        System.out.println("Checking/removing expired NPCs...");
        npcRepository.removeOldNpcs();
    }
}
