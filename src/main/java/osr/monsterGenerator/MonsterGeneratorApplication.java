package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.Systems;

@SpringBootApplication
public class MonsterGeneratorApplication {

	@Autowired
	private static NPCFactory npcFactory;

	public static void main(String[] args) {
		SpringApplication.run(MonsterGeneratorApplication.class, args);
		DndNPC firstDndNPC = (DndNPC)npcFactory.generateMonster(Systems.BASENPC);

	}

}
