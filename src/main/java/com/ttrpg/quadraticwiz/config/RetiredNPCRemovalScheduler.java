package com.ttrpg.quadraticwiz.config;

import com.ttrpg.quadraticwiz.repository.NPCDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class RetiredNPCRemovalScheduler {

    private final NPCDao npcDao;

    // 12 hours
    @Scheduled(fixedRate = 43200000L)
    private void removeOldNPCs() {
        System.out.println("Checking/removing expired NPCs...");
        npcDao.removeOldNpcs();
    }
}
