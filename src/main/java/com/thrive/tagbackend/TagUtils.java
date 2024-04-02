package com.thrive.tagbackend;

public class TagUtils {
    public static String getGroupAndElement(int group, int element) {
        return Integer.toHexString(group) + ", " + Integer.toHexString(element);
    }

    public static int getGroup(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(", ")[0], 16);
    }

    public static int getElement(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(", ")[1], 16);
    }
}
