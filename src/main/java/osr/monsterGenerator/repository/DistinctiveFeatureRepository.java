package osr.monsterGenerator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import osr.monsterGenerator.npc.npcAttributes.DistinctiveFeature;

public interface DistinctiveFeatureRepository extends MongoRepository<String, String> {
    DistinctiveFeature findDistinctiveFeatureByName(String name);

}
