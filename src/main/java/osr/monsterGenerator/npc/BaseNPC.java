package osr.monsterGenerator.npc;

import osr.monsterGenerator.npcAttributes.PhysicalAttack;
import osr.monsterGenerator.service.RandomizeAttributeService;

import java.util.Random;

// A basic monster or NPC
public class BaseNPC {
    // Perhaps tied to body shape or distinct features?  For example, a reptilian creature could use a latin name
    // from that part of the animal kingdom
    private String name;
    private String properName;
    // Generic flat health points, if desired
    private String healthPoints;
    private String size;
    private int experienceGiven;
    private String generalBodyShape;
    private String bodyCharacteristics;
    private String movementStyle;
    private String movementSpeed;
    private String distinctiveFeatures;
    private PhysicalAttack[] physicalAttacks;
    private String[] specialAbilities;
    private String combatStrategyPrimary;
    private String combatStrategySecondary;
    private String[] motivations;

    public BaseNPC(){
        this.size = RandomizeAttributeService.getRandomSize();
        this.generalBodyShape = RandomizeAttributeService.getRandomSize();
        this.bodyCharacteristics = RandomizeAttributeService.getRandomBodyCharacteristics();
        this.movementStyle = RandomizeAttributeService.getRandomMovementStyle();
        this.movementSpeed = RandomizeAttributeService.getRandomMovementSpeed();
        this.distinctiveFeatures = RandomizeAttributeService.getDistinctiveFeatures();
        this.combatStrategyPrimary = RandomizeAttributeService.getCombatStrategy();
        this.combatStrategySecondary = RandomizeAttributeService.getCombatStrategy();
        this.motivations = RandomizeAttributeService.getMotivations();
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

    public String getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(String healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getMovementStyle() {
        return movementStyle;
    }

    public void setMovementStyle(String movementStyle) {
        this.movementStyle = movementStyle;
    }

    public String getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(String movementSpeed) {
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

    public String[] getMotivations() {
        return motivations;
    }

    public void setMotivations(String[] motivations) {
        this.motivations = motivations;
    }

}
