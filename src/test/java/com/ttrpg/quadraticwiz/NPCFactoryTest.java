package com.ttrpg.quadraticwiz;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ttrpg.quadraticwiz.model.Systems;
import com.ttrpg.quadraticwiz.repositories.entities.BaseNpcEntity;
import com.ttrpg.quadraticwiz.repositories.entities.DndNpcEntity;
import com.ttrpg.quadraticwiz.repositories.entities.MothershipNpcEntity;
import com.ttrpg.quadraticwiz.services.api.NpcFactory;
import com.ttrpg.quadraticwiz.utilities.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NpcFactoryTest {

    @Autowired
    private NpcFactory NpcFactory;

    // TODO Write
    @Test
    public void generateDNDNpcTest() {
        DndNpcEntity testMon = (DndNpcEntity) NpcFactory.generateNpc(Systems.DND5E);
        boolean passed = false;
        Assert.assertTrue(passed);

    }

    @Test
    public void generateMothershipNpcTest(){
        MothershipNpcEntity npc = (MothershipNpcEntity) NpcFactory.generateNpc(Systems.MOTHERSHIP);
        boolean passed = false;

    }

    @Test
    public void generateBaseNpcTest(){
        BaseNpcEntity testMon = NpcFactory.generateNpc(Systems.BASE);
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