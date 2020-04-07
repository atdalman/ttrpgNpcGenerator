package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import osr.monsterGenerator.npc.Monster;
import osr.monsterGenerator.service.NPCFactory;

@SpringBootApplication
public class MonsterGeneratorApplication {

	@Autowired
	private static NPCFactory npcFactory;

	public static void main(String[] args) {
		SpringApplication.run(MonsterGeneratorApplication.class, args);
		Monster firstMonster = npcFactory.generateMonster("Monster");

	}

}
