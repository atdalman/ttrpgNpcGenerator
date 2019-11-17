package osr.monsterGenerator.npc;

import osr.monsterGenerator.mechanicalProperties.Alignment;
import osr.monsterGenerator.mechanicalProperties.PhysicalAttack;
import osr.monsterGenerator.mechanicalProperties.SavingThrow;

public class Monster {
    private String alignment;
    private String name;
    private String properName;
    private String armorClass;
    private int healthPoints;
    private int hitDie;
    private int experienceGiven;
    private String generalBodyShape;
    private String bodyCharacteristics;
    private String size;
    private String movementStyle;
    private int movementSpeed;
    private String distinctiveFeatures;
    private PhysicalAttack[] physicalAttacks;
    private String[] specialAbilities;
    private String combatStrategyPrimary;
    private String combatStrategySecondary;
    private String motivation;
    private SavingThrow[] savingThrows;
    private String morale;

    public Monster() {

    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperName() {
        return properName;
    }

    public void setProperName(String properName) {
        this.properName = properName;
    }

    public String getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(String armorClass) {
        this.armorClass = armorClass;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHitDie() {
        return hitDie;
    }

    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    public int getExperienceGiven() {
        return experienceGiven;
    }

    public void setExperienceGiven(int experienceGiven) {
        this.experienceGiven = experienceGiven;
    }

    public String getGeneralBodyShape() {
        return generalBodyShape;
    }

    public void setGeneralBodyShape(String generalBodyShape) {
        this.generalBodyShape = generalBodyShape;
    }

    public String getBodyCharacteristics() {
        return bodyCharacteristics;
    }

    public void setBodyCharacteristics(String bodyCharacteristics) {
        this.bodyCharacteristics = bodyCharacteristics;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getDistinctiveFeatures() {
        return distinctiveFeatures;
    }

    public void setDistinctiveFeatures(String distinctiveFeatures) {
        this.distinctiveFeatures = distinctiveFeatures;
    }

    public PhysicalAttack[] getPhysicalAttacks() {
        return physicalAttacks;
    }

    public void setPhysicalAttacks(PhysicalAttack[] physicalAttacks) {
        this.physicalAttacks = physicalAttacks;
    }

    public String[] getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(String[] specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public String getCombatStrategyPrimary() {
        return combatStrategyPrimary;
    }

    public void setCombatStrategyPrimary(String combatStrategyPrimary) {
        this.combatStrategyPrimary = combatStrategyPrimary;
    }

    public String getCombatStrategySecondary() {
        return combatStrategySecondary;
    }

    public void setCombatStrategySecondary(String combatStrategySecondary) {
        this.combatStrategySecondary = combatStrategySecondary;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public SavingThrow[] getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(SavingThrow[] savingThrows) {
        this.savingThrows = savingThrows;
    }

    public String getMorale() {
        return morale;
    }

    public void setMorale(String morale) {
        this.morale = morale;
    }
}
