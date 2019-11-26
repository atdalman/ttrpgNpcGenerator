package osr.monsterGenerator.utilities;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class CVSReader {
// todo return array
    public ArrayList<String> readCVS(String cvsName){
        ArrayList<String> bodyList = new ArrayList();
        String csvFile = "static/generalBodyShapes";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] bodyShapes = line.split(cvsSplitBy);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
