package com.luckydu.dujun.circleoffriends.util;

/**
 *
 * Created by dujun on 2017-08-06.
 */

public class StringUtils {

    public static boolean isNull(String s) {
        return s == null || s.trim().equals("") || s.trim().equalsIgnoreCase("null");
    }
}
