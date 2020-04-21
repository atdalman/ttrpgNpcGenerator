package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;
import osr.monsterGenerator.utilities.*;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomizeAttributeService {

    public String getRandomAlignment() {
        return Alignments.selectRandomAlignment();
    }

    public String getRandomProperName(int speciesType) {
        //TODO Write generic humanoid name generator
        return "PROPERNAME";
    }

    public String getRandomName(){
        return "NAME";
    }

    public String healthPoints(){
        return "666";
    }

    public static String getRandomSize(){
        return Sizes.getRandomSize();
    }

    // TODO Determine good average ranges.  Weight ranges might be a good idea?
    public int hitDie(Systems system){

        switch(system){
            case ASSH:
                return ThreadLocalRandom.current().nextInt(1, 5);
            case DND5E:
                return ThreadLocalRandom.current().nextInt(1, 5);

            case OSROTHER:
                return ThreadLocalRandom.current().nextInt(1, 5);
            default:
                return ThreadLocalRandom.current().nextInt(1, 5);

        }
    }

    public String generalBodyShape() {
        return BodyShape.selectRandomBodyShape();
    }
}
