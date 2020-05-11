package osr.monsterGenerator.npcAttributes;

import java.util.concurrent.ThreadLocalRandom;

public enum BodyShape {
    CIRCULAR,
    SQUARE,
    BIPEDAL,
    HEXAGONAL,
    OCTAGONAL,
    CYLINDRICAL,
    AMORPHOUSMASS,
    AVIAN,
    SERPENTINE,
    UNKNOWABLE;

    public static String selectRandomBodyShape() {
        int numAlignments = BodyShape.values().length;
        int randNum = ThreadLocalRandom.current().nextInt(1, numAlignments+1);

        String shape;
        switch (randNum) {
            case 1:
                shape= BodyShape.CIRCULAR.toString();
                break;
            case 2:
                shape= BodyShape.SQUARE.toString();
                break;
            case 3:
                shape= BodyShape.BIPEDAL.toString();
                break;
            case 4:
                shape= BodyShape.HEXAGONAL.toString();
                break;
            case 5:
                shape= BodyShape.OCTAGONAL.toString();
                break;
            case 6:
                shape= BodyShape.CYLINDRICAL.toString();
                break;
            case 7:
                shape= BodyShape.AMORPHOUSMASS.toString();
                break;
            case 8:
                shape= BodyShape.UNKNOWABLE.toString();
                break;
            default:
                shape = "None";
        }
        return shape;
    }
}
