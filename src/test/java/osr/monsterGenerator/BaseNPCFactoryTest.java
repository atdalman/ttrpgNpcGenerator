package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.npc.MothershipNPC;
import osr.monsterGenerator.npc.BaseNPC;
import osr.monsterGenerator.npcAttributes.PhysicalAttack;
import osr.monsterGenerator.npcAttributes.SavingThrow;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.StringUtils;
import osr.monsterGenerator.utilities.Systems;

public class BaseNPCFactoryTest {

    @Autowired
    private NPCFactory NPCFactory;

    // TODO Write
    @Test
    public void generateDNDNPCTest(){
        DndNPC testMon = (DndNPC)NPCFactory.generateMonster(Systems.DND5E);
        boolean passed = false;
        Assert.assertTrue(passed);

    }

    @Test
    public void generateMothershipNPCTest(){
        MothershipNPC npc = (MothershipNPC)NPCFactory.generateMonster(Systems.MOTHERSHIP);
        boolean passed = false;

    }

    @Test
    public void generateBaseNPCTest(){
        BaseNPC testMon = NPCFactory.generateMonster(Systems.BASENPC);
        boolean passed = false;
        if(!StringUtils.isStringNullOrBlank(testMon.getName())
                && !StringUtils.isStringNullOrBlank(testMon.getHealthPoints())
                && !StringUtils.isStringNullOrBlank(testMon.getSize())
                && testMon.getExperienceGiven() >= 0
                && StringUtils.isStringNullOrBlank(testMon.getGeneralBodyShape())
                && StringUtils.isStringNullOrBlank(testMon.getBodyCharacteristics())
                && StringUtils.isStringNullOrBlank(testMon.getMovementStyle())
                && StringUtils.isStringNullOrBlank(testMon.getMovementSpeed())
                && StringUtils.isStringNullOrBlank(testMon.getDistinctiveFeatures())
                && testMon.getPhysicalAttacks().length > 0
                && testMon.getSpecialAbilities().length > 0
                && StringUtils.isStringNullOrBlank(testMon.getCombatStrategyPrimary())
                && StringUtils.isStringNullOrBlank(testMon.getCombatStrategySecondary())
                && testMon.getMotivations().length > 0
        ){
            passed = true;
        }
        Assert.assertTrue(passed);
    }

}
