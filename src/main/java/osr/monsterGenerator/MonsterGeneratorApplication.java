package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import osr.monsterGenerator.service.AttributeService;
import osr.monsterGenerator.service.NPCFactory;

@SpringBootApplication
public class MonsterGeneratorApplication implements CommandLineRunner {

	@Autowired
	private NPCFactory npcFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private AttributeService attributeService;

	public static void main(String[] args) {
		SpringApplication.run(MonsterGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//DndNPC firstDndNPC = (DndNPC) npcFactory.generateMonster(Systems.BASENPC);
		//mongoTemplate.insert(new DistinctiveFeature());
		//mongoTemplate.remove(new Query(), "distinctiveFeature");
		System.out.println(attributeService.getMovement().getMovementStyle());
	}

}