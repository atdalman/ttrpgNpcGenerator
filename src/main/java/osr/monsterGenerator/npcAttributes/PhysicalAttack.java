package osr.monsterGenerator.npcAttributes;

public class PhysicalAttack {

    private String name; // claw/bite/strike
    private int flatDamage; // average damage
    private int damageRoll; // d4/d6/etc
    private String specialEffect;

    public PhysicalAttack(){

    }

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

    public int getDamageRoll() {
        return damageRoll;
    }

    public void setDamageRoll(int damageRoll) {
        this.damageRoll = damageRoll;
    }

    public String getSpecialEffect() {
        return specialEffect;
    }

    public void setSpecialEffect(String specialEffect) {
        this.specialEffect = specialEffect;
    }

}