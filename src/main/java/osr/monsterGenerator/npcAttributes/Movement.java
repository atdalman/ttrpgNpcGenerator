package osr.monsterGenerator.npcAttributes;

import org.springframework.data.annotation.Id;

public class Movement {
    @Id
    private String _id;
    private String movementStyle;
    private int movementSpeed;
    private int numLimbs;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

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
                "_id='" + _id + '\'' +
                ", movementStyle='" + movementStyle + '\'' +
                ", movementSpeed=" + movementSpeed +
                ", numLimbs=" + numLimbs +
                '}';
    }
}
