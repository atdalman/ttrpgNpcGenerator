package osr.monsterGenerator.npc.npcAttributes;

import org.springframework.data.annotation.Id;

public class Movement {
    @Id
    private String movementStyle;
    private int movementSpeed;
    private int numLimbs;

    public String getMovementStyle() {
        return movementStyle;
    }

    public void setMovementStyle(String movementStyle) {
        this.movementStyle = movementStyle;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getNumLimbs() {
        return numLimbs;
    }

    public void setNumLimbs(int numLimbs) {
        this.numLimbs = numLimbs;
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
