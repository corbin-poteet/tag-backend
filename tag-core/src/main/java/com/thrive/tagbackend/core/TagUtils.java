package com.thrive.tagbackend.core;

import com.thrive.tagbackend.core.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagUtils {
    public static String toGroupAndElement(int group, int element) {
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

    public static Tag getRandomTag(int group, int element) {
        String tagValue = getRandomTagValue();
        return new Tag(
                TagUtils.toGroupAndElement(group, element),
                "TransferSyntaxUID",
                "UI",
                String.valueOf(tagValue.length()),
                "1",
                tagValue,
                group,
                element,
                false
        );
    }

    public static List<Tag> getRandomTags(int maxGroup, int maxElement) {
        List<Tag> tags = new ArrayList<>();

        for (int group = 0; group <= maxGroup; group++) {
            for (int element = 0; element <= maxElement; element++) {
                tags.add(getRandomTag(group, element));
            }
        }

        return tags;
    }


        public static String getRandomTagValue() {
        StringBuilder tagValue = new StringBuilder();
        int[] multipliers = {10, 10, 1000, 100000, 10, 10, 10, 100};

        for (int i = 0; i < 8; i++) {
            if (i != 0) {
                tagValue.append(".");
            }
            tagValue.append((int) (Math.random() * multipliers[i]));
        }

        return tagValue.toString();
    }
}
