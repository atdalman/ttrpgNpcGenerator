package osr.monsterGenerator.config;

import org.springframework.beans.factory.InitializingBean;
import osr.monsterGenerator.utilities.Sizes;
import osr.monsterGenerator.utilities.WeightedItemList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Init implements InitializingBean {

    @Override
    public void afterPropertiesSet()  {
        try {
            OutputStream output = new FileOutputStream("properties\\sizes.properties");
        } catch(FileNotFoundException e){
            // TODO Add logging
            System.out.println("Size prop file not found");
        }
    }
}