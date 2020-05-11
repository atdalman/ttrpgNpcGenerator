package osr.monsterGenerator.npcAttributes;

import osr.monsterGenerator.utilities.WeightedItemList;

import javax.annotation.PostConstruct;

// TO-DO Remove and put random functionality in attribute service
public enum Sizes {
    MEDIUM(30),
    LARGE(30),
    SMALL(25),
    TINY(10),
    SWARM(10),
    MICROSCOPIC(1),
    HUGE(1),
    GARGANTUAN(.5),
    PLANETARY(.1),
    GALAXIAN(.01);

    public double weight;
    public static WeightedItemList sizeList;

    Sizes(double weight){
        this.weight = weight;
    }

    public static String getRandomSize(){
        return (String)sizeList.getRandom();
    }

    @PostConstruct
    public static void createSizeList(){
        sizeList = new WeightedItemList();

        for(Sizes size : Sizes.values())
            Sizes.sizeList.addEntry(size.name(), size.weight);
    }
}