package com.thrive.tagbackend.core;

public class TagUtils {
    public static String getGroupAndElement(int group, int element) {
        String groupHex = Integer.toHexString(group);
        String paddedGroupHex = "0".repeat(4 - groupHex.length()) + groupHex;

        String elementHex = Integer.toHexString(element);
        String paddedElementHex = "0".repeat(4 - elementHex.length()) + elementHex;

        return paddedGroupHex + "," + paddedElementHex;
    }

    public static int getGroup(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(",")[0], 16);
    }

    public static int getElement(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(",")[1], 16);
    }
}
