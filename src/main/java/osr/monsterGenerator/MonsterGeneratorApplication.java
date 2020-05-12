package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import osr.monsterGenerator.repository.MovementRepository;
import osr.monsterGenerator.service.NPCFactory;

@SpringBootApplication
public class MonsterGeneratorApplication implements CommandLineRunner {

	@Autowired
	private static NPCFactory npcFactory;

	@Autowired
	MovementRepository movementRepo;

	public static void main(String[] args) {
		SpringApplication.run(MonsterGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args){
		//DndNPC firstDndNPC = (DndNPC)npcFactory.generateMonster(Systems.BASENPC);
		System.out.println(movementRepo.findAll());
	}

}
