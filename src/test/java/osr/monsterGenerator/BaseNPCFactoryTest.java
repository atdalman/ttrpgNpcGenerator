package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.model.Systems;
import osr.monsterGenerator.model.npc.BaseNPC;
import osr.monsterGenerator.model.npc.DndNPC;
import osr.monsterGenerator.model.npc.MothershipNPC;
import osr.monsterGenerator.service.NPCFactory;
import osr.monsterGenerator.utilities.StringUtils;

public class BaseNPCFactoryTest {

    @Autowired
    private NPCFactory NPCFactory;

    // TODO Write
    @Test
    public void generateDNDNPCTest() {
        DndNPC testMon = (DndNPC) NPCFactory.generateNPC(Systems.DND5E);
        boolean passed = false;
        Assert.assertTrue(passed);

    }

    @Test
    public void generateMothershipNPCTest(){
        MothershipNPC npc = (MothershipNPC) NPCFactory.generateNPC(Systems.MOTHERSHIP);
        boolean passed = false;

    }

    @Test
    public void generateBaseNPCTest(){
        BaseNPC testMon = NPCFactory.generateNPC(Systems.BASENPC);
        boolean passed = false;
        if(!StringUtils.isStringNullOrBlank(testMon.getName())
                && testMon.getSize() != null
                && testMon.getGeneralBodyShape() != null
                && testMon.getBodySurface() != null
                && testMon.getDistinctiveFeature() != null
                && testMon.getMovement() != null
                && testMon.getCombatStrategies().size() > 0
                && testMon.getMotivations().size() > 0
        ){
            passed = true;
        }
        Assert.assertTrue(passed);
    }

}