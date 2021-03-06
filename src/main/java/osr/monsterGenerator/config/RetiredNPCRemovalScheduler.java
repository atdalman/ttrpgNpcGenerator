package osr.monsterGenerator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import osr.monsterGenerator.repository.NPCDao;

@EnableScheduling
@Configuration
public class RetiredNPCRemovalScheduler {

    @Autowired
    NPCDao npcDao;

    // 12 hours
    @Scheduled(fixedRate = 43200000L)
    private void removeOldNPCs() {
        System.out.println("Checking/removing expired NPCs...");
        npcDao.removeOldNpcs();
    }
}
