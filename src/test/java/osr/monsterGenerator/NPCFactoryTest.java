package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.npc.Monster;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.service.StringUtils;

public class NPCFactoryTest {

    @Autowired
    private NPCFactory NPCFactory;

    @Autowired
    private StringUtils stringUtils;

    @Test
    public void generateMonsterTest(){
        Monster testMon = NPCFactory.generateMonster("monster");
        boolean passed = false;
        if(testMon.getHitDie() > 0
                && !StringUtils.isStringNullOrBlank(testMon.getArmorClass())
        && !StringUtils.isStringNullOrBlank(testMon.getBodyCharacteristics())
        && StringUtils.isStringNullOrBlank(testMon.getGeneralBodyShape())
        && StringUtils.isStringNullOrBlank(testMon.getDistinctiveFeatures())
        && StringUtils.isStringNullOrBlank(testMon.getMovementStyle())
        && testMon.getPhysicalAttacks().length > 0
        && StringUtils.isStringNullOrBlank(testMon.getCombatStrategyPrimary())){
            passed = true;
        }
        Assert.assertTrue(passed);

    }
}
