package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.npc.MothershipNPC;
import osr.monsterGenerator.npc.BaseNPC;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.StringUtils;
import osr.monsterGenerator.utilities.Systems;

public class BaseNPCFactoryTest {

    @Autowired
    private NPCFactory NPCFactory;

    @Autowired
    private StringUtils stringUtils;

    @Test
    public void generateMonsterTest(){
        DndNPC testMon = (DndNPC)NPCFactory.generateMonster(Systems.DND5E);
        boolean passed = false;
        if(!StringUtils.isStringNullOrBlank(testMon.getHitDie())
                && testMon.getArmorClass() > Integer.MIN_VALUE
        && !StringUtils.isStringNullOrBlank(testMon.getBodyCharacteristics())
        && !StringUtils.isStringNullOrBlank(testMon.getGeneralBodyShape())
        && !StringUtils.isStringNullOrBlank(testMon.getDistinctiveFeatures())
        && !StringUtils.isStringNullOrBlank(testMon.getMovementStyle())
        && testMon.getPhysicalAttacks().length > 0
        && !StringUtils.isStringNullOrBlank(testMon.getCombatStrategyPrimary())){
            passed = true;
        }
        Assert.assertTrue(passed);

    }

    @Test
    public void generateMothershipNPC(){
        MothershipNPC npc = (MothershipNPC)NPCFactory.generateMonster(Systems.MOTHERSHIP);
        boolean passed = false;

    }

    @Test
    public void generateBasicMonster(){
        BaseNPC baseNpc = NPCFactory.generateMonster(Systems.BASENPC);
        boolean passed = false;


    }

}
