package framework.utils;

import java.util.Random;

public class StringUtils {

    private final static String CHARS = "abcdefghijklmnopqrstuvwxyz";

    public static String getRandomText (int size){
        char[] chars = CHARS.toCharArray();
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }
}