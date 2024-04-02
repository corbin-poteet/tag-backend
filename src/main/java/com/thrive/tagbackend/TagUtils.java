package com.thrive.tagbackend;

public class TagUtils {
    public static String getGroupAndElement(int group, int element) {
        System.out.println("groupAndElement: " + group + "," + element);


        String groupHex = Integer.toHexString(group);
        String paddedGroupHex = "0".repeat(4 - groupHex.length()) + groupHex;

        String elementHex = Integer.toHexString(element);
        String paddedElementHex = "0".repeat(4 - elementHex.length()) + elementHex;

        String groupAndElement = paddedGroupHex + "," + paddedElementHex;
        System.out.println("groupAndElement: " + groupAndElement);
        return groupAndElement;
    }

    public static int getGroup(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(",")[0], 16);
    }

    public static int getElement(String groupAndElement) {
        return Integer.parseInt(groupAndElement.split(",")[1], 16);
    }
}
