package osr.monsterGenerator.npc;

import osr.monsterGenerator.mechanicalProperties.PhysicalAttack;
import osr.monsterGenerator.mechanicalProperties.SavingThrow;

// Included for the purpose of expanding this to systems where NPCs and monsters are treated separately
public interface NPC {
    String getAlignment();

    void setAlignment(String alignment);

    String getName();

    void setName(String name);

    String getProperName();

    void setProperName(String properName);

    int getArmorClass();

    void setArmorClass(int armorClass);

    int getHealthPoints();

    void setHealthPoints(int healthPoints);

    int getHitDie();

    void setHitDie(int hitDie);

    int getExperienceGiven();

    void setExperienceGiven(int experienceGiven);

    String getGeneralBodyShape();

    void setGeneralBodyShape(String generalBodyShape);

    String getBodyCharacteristics();

    void setBodyCharacteristics(String bodyCharacteristics);

    String getSize();

    void setSize(String size);

    String getMovementStyle();

    void setMovementStyle(String movementStyle);

    int getMovementSpeed();

    void setMovementSpeed(int movementSpeed);

    String getDistinctiveFeatures();

    void setDistinctiveFeatures(String distinctiveFeatures);

    PhysicalAttack[] getPhysicalAttacks();

    void setPhysicalAttacks(PhysicalAttack[] physicalAttacks);

    String[] getSpecialAbilities();

    void setSpecialAbilities(String[] specialAbilities);

    String getCombatStrategyPrimary();

    void setCombatStrategyPrimary(String combatStrategyPrimary);

    String getCombatStrategySecondary();

    void setCombatStrategySecondary(String combatStrategySecondary);

    String getMotivation();

    void setMotivation(String motivation);

    SavingThrow[] getSavingThrows();

    void setSavingThrows(SavingThrow[] savingThrows);

    String getMorale();

    void setMorale(String morale);
}
