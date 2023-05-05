package ttrpg.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ttrpg.monsterGenerator.model.Systems;
import ttrpg.monsterGenerator.model.npc.BaseNPC;
import ttrpg.monsterGenerator.model.npc.DndNPC;
import ttrpg.monsterGenerator.model.npc.MothershipNPC;
import ttrpg.monsterGenerator.service.NPCFactory;
import ttrpg.monsterGenerator.utilities.StringUtils;

public class NPCFactoryTest {

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
        BaseNPC testMon = NPCFactory.generateNPC(Systems.BASE);
        boolean passed = false;
        if (!StringUtils.isStringNullOrBlank(testMon.getSpecies())
                && testMon.getSize() != null
                && testMon.getBodyShape() != null
                && testMon.getBodySurface() != null
                && testMon.getPeculiarCharacteristic() != null
                && testMon.getMovement() != null
                && testMon.getCombatStrategies().size() > 0
                && testMon.getMotivations().size() > 0
        ) {
            passed = true;
        }
        Assert.assertTrue(passed);
    }

}