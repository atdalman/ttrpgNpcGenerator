package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.npc.DndNPC;
import osr.monsterGenerator.npc.MothershipNPC;
import osr.monsterGenerator.npc.NPC;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.StringUtils;

public class NPCFactoryTest {

    @Autowired
    private NPCFactory NPCFactory;

    @Autowired
    private StringUtils stringUtils;

    @Test
    public void generateMonsterTest(){
        DndNPC testMon = (DndNPC)NPCFactory.generateMonster("monster");
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
        MothershipNPC npc = (MothershipNPC)NPCFactory.generateMonster("mothership");
        boolean passed = false;

    }

    @Test
    public void generateBasicMonster(){
        NPC npc = NPCFactory.generateMonster("base");
        boolean passed = false;


    }

}
