package osr.monsterGenerator.model.npc.npcAttributes;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import osr.monsterGenerator.utilities.RandomUtils;

@Data
public class Movement extends NPCAttribute {
    /*
        Speed relative to the average speed of a human jogging, which is "1".  Take this speed, and multiply by a
        given system's multiplier.  Example:  D&D's will be 30ft, so the final outputted speed for D&D will be "30"
        for a jogger.
     */
    private double movementSpeed;
    @Transient
    private int numLimbs;
    private int[] possibleNumLimbs;

    public void setNumLimbsFromPossible() {
        this.numLimbs = possibleNumLimbs[RandomUtils.getRandomIntWithUpperBound(possibleNumLimbs.length - 1)];
    }

    public String toString() {
        return "Movement{" +
                ", movementStyle='" + getDescription() + '\'' +
                ", movementSpeed=" + movementSpeed +
                ", numLimbs=" + numLimbs +
                '}';
    }
}
