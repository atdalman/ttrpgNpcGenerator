package com.ttrpg.quadraticwiz.utilities;

public class StringUtils {
    public static boolean isStringNullOrBlank(String str){
        return str == null || str.isEmpty();
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
