package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repository.api.NPCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class RetiredNPCRemovalScheduler {

    private final NPCRepository npcRepository;

    // 12 hours
    @Scheduled(fixedRate = 43200000L)
    private void removeOldNPCs() {
        System.out.println("Checking/removing expired NPCs...");
        npcRepository.removeOldNpcs();
    }
}
