package osr.monsterGenerator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import osr.monsterGenerator.utilities.CVSReader;

import java.util.ArrayList;

public class CVSReaderTest {

    @Autowired
    CVSReader reader;

    @Test
    public void readCVSTest(){
        ArrayList<String> bodyList = reader.readCVS("generalBodyShape");
        Assert.assertTrue(!bodyList.isEmpty());
    }
}
