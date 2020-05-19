package osr.monsterGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import osr.monsterGenerator.npc.npcAttributes.BodySurface;
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
		mongoTemplate.remove(new Query(), "bodySurface");
		BodySurface surface = new BodySurface();
		for (BodySurfaceCharacteristics curr : BodySurfaceCharacteristics.values()) {
			surface = new BodySurface();
			surface.setName(curr.name().toLowerCase());
			surface.setDescription("");
			mongoTemplate.insert(surface);
		}
	}

}