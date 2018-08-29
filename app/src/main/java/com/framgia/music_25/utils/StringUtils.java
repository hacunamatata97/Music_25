package com.framgia.music_25.utils;

public final class StringUtils {

    /**
     * Capitalize first letter each word in text
     *
     * @param text - input String
     * @return String with capitalized letter
     */
    public static String capitalize(String text) {
        String[] temp = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String s : temp) {
            s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            result.append(s).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }
}
