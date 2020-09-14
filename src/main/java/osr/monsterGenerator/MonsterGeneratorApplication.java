package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.repository.AttributeDAO;
import osr.monsterGenerator.service.AttributeService;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.Systems;

@SpringBootApplication
public class MonsterGeneratorApplication implements CommandLineRunner {

	@Autowired
	private NPCFactory npcFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private AttributeService attributeService;

	@Autowired
	private AttributeDAO attributeDAO;

	public static void main(String[] args) {
		SpringApplication.run(MonsterGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) {
		BaseNPC firstDndNPC = npcFactory.generateNPC(Systems.BASENPC);
		System.out.println(firstDndNPC.toString());
		attributeDAO.updateCumulativeByCollection("size");
	}

}