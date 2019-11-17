package osr.monsterGenerator.mechanicalProperties;

public class PhysicalAttack {

    private String name; // claw/bite/strike
    private int flatDamage; // average damage
    private String damageRoll; // d4/d6/etc
    private String specialEffect; //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlatDamage() {
        return flatDamage;
    }

    public void setFlatDamage(int flatDamage) {
        this.flatDamage = flatDamage;
    }

    public String getDamageRoll() {
        return damageRoll;
    }

    public void setDamageRoll(String damageRoll) {
        this.damageRoll = damageRoll;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }

    public void setSpecialEffect(String specialEffect) {
        this.specialEffect = specialEffect;
    }
}
