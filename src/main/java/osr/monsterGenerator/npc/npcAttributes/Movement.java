package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import osr.monsterGenerator.service.AttributeService;

public class Movement {

    @Id
    private String id;
    private String movementStyle;

    /*
        Speed relative to the average speed of a human jogging, which is "1".  Take this speed, and multiply by a
        given system's multiplier.  Example:  D&D's will be 30ft, so the final outputted speed for D&D will be "30"
        for a jogger.
     */
    private double movementSpeed;
    @Transient
    private int numLimbs;
    private int[] possibleNumLimbs;

    public String getMovementStyle() {
        return movementStyle;
    }

    public void setMovementStyle(String movementStyle) {
        this.movementStyle = movementStyle;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getNumLimbs() {
        return numLimbs;
    }

    public void setNumLimbs(int numLimbs) {
        this.numLimbs = numLimbs;
    }

    public void setNumLimbsFromPossible() {
        this.numLimbs = possibleNumLimbs[AttributeService.getRandomNum(possibleNumLimbs.length - 1)];
    }

    public int[] getPossibleNumLimbs() {
        return possibleNumLimbs;
    }

    public void setPossibleNumLimbs(int[] possibleNumLimbs) {
        this.possibleNumLimbs = possibleNumLimbs;
    }

    @Override
    public String toString() {
        return "Movement{" +
                ", movementStyle='" + movementStyle + '\'' +
                ", movementSpeed=" + movementSpeed +
                ", numLimbs=" + numLimbs +
                '}';
    }
}
