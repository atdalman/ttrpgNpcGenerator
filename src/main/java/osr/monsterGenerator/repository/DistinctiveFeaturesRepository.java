package osr.monsterGenerator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistinctiveFeaturesRepository extends MongoRepository<String, String> {
    String findDistinctiveFeatureByName(String name);

}
