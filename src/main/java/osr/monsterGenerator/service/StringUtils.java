package osr.monsterGenerator.service;

import org.springframework.stereotype.Service;

@Service
public class StringUtils {
    public static boolean isStringNullOrBlank(String str){
        return str == null || str.isEmpty();
    }
}
