package osr.monsterGenerator.utilities;

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

    // TODO May not be needed, as MongoTemplate.getCollectionName() fulfills the same function
    public static String toCamelCaseFromTitleCase(String word) {
        if (word == null || word.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(word.charAt(0)));
        sb.append(word.substring(1));

        return sb.toString();
    }
}
