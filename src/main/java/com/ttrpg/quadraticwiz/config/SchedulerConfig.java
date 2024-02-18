package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repositories.api.AttributeRepository;
import com.ttrpg.quadraticwiz.repositories.api.NpcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

// Place to save and periodically update the chances of attributes occurring in Mongo
@EnableScheduling
@Configuration
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {

    private final AttributeRepository attributeRepository;
    private final NpcRepository npcRepository;

    // 10 minutes
    @Scheduled(fixedRate = 600000L)
    private void updateCumulativeChances() {
        log.info("Running chance scheduler...");
        attributeRepository.updateChances("size");
    }

    @Scheduled(fixedRate = 43200000L)
    private void removeOldNpcs() {
        log.info("Checking/removing expired Npcs...");
        npcRepository.removeOldNpcs();
    }
}
