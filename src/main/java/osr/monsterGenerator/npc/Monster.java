package osr.monsterGenerator.npc;

import osr.monsterGenerator.mechanicalProperties.PhysicalAttack;
import osr.monsterGenerator.mechanicalProperties.SavingThrow;

public class Monster implements NPC {
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

    @Override
    public String getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProperName() {
        return properName;
    }

    @Override
    public void setProperName(String properName) {
        this.properName = properName;
    }

    @Override
    public String getArmorClass() {
        return armorClass;
    }

    @Override
    public void setArmorClass(String armorClass) {
        this.armorClass = armorClass;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public int getHitDie() {
        return hitDie;
    }

    @Override
    public void setHitDie(int hitDie) {
        this.hitDie = hitDie;
    }

    @Override
    public int getExperienceGiven() {
        return experienceGiven;
    }

    @Override
    public void setExperienceGiven(int experienceGiven) {
        this.experienceGiven = experienceGiven;
    }

    @Override
    public String getGeneralBodyShape() {
        return generalBodyShape;
    }

    @Override
    public void setGeneralBodyShape(String generalBodyShape) {
        this.generalBodyShape = generalBodyShape;
    }

    @Override
    public String getBodyCharacteristics() {
        return bodyCharacteristics;
    }

    @Override
    public void setBodyCharacteristics(String bodyCharacteristics) {
        this.bodyCharacteristics = bodyCharacteristics;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getMovementStyle() {
        return movementStyle;
    }

    @Override
    public void setMovementStyle(String movementStyle) {
        this.movementStyle = movementStyle;
    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public String getDistinctiveFeatures() {
        return distinctiveFeatures;
    }

    @Override
    public void setDistinctiveFeatures(String distinctiveFeatures) {
        this.distinctiveFeatures = distinctiveFeatures;
    }

    @Override
    public PhysicalAttack[] getPhysicalAttacks() {
        return physicalAttacks;
    }

    @Override
    public void setPhysicalAttacks(PhysicalAttack[] physicalAttacks) {
        this.physicalAttacks = physicalAttacks;
    }

    @Override
    public String[] getSpecialAbilities() {
        return specialAbilities;
    }

    @Override
    public void setSpecialAbilities(String[] specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    @Override
    public String getCombatStrategyPrimary() {
        return combatStrategyPrimary;
    }

    @Override
    public void setCombatStrategyPrimary(String combatStrategyPrimary) {
        this.combatStrategyPrimary = combatStrategyPrimary;
    }

    @Override
    public String getCombatStrategySecondary() {
        return combatStrategySecondary;
    }

    @Override
    public void setCombatStrategySecondary(String combatStrategySecondary) {
        this.combatStrategySecondary = combatStrategySecondary;
    }

    @Override
    public String getMotivation() {
        return motivation;
    }

    @Override
    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    @Override
    public SavingThrow[] getSavingThrows() {
        return savingThrows;
    }

    @Override
    public void setSavingThrows(SavingThrow[] savingThrows) {
        this.savingThrows = savingThrows;
    }

    @Override
    public String getMorale() {
        return morale;
    }

    @Override
    public void setMorale(String morale) {
        this.morale = morale;
    }
}
