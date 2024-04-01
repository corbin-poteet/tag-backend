package com.thrive.tagbackend.model;

public class Tag {
    private String groupAndElement;
    private String tagDescription;
    private String valueRepresentation;
    private String tagLength;
    private String tagMultiplicity;
    private String value;
    private int group;
    private int element;
    private boolean editable;

    public Tag() {
    }

    public Tag(String groupAndElement, String tagDescription, String valueRepresentation, String tagLength, String tagMultiplicity, String value, int group, int element, boolean editable) {
        this.groupAndElement = groupAndElement;
        this.tagDescription = tagDescription;
        this.valueRepresentation = valueRepresentation;
        this.tagLength = tagLength;
        this.tagMultiplicity = tagMultiplicity;
        this.value = value;
        this.group = group;
        this.element = element;
        this.editable = editable;
    }

    //<editor-fold desc="Getters">
    public String getGroupAndElement() {
        return groupAndElement;
    }

    public void setGroupAndElement(String groupAndElement) {
        this.groupAndElement = groupAndElement;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public String getValueRepresentation() {
        return valueRepresentation;
    }

    public void setValueRepresentation(String valueRepresentation) {
        this.valueRepresentation = valueRepresentation;
    }

    public String getTagLength() {
        return tagLength;
    }

    public void setTagLength(String tagLength) {
        this.tagLength = tagLength;
    }

    public String getTagMultiplicity() {
        return tagMultiplicity;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setTagMultiplicity(String tagMultiplicity) {
        this.tagMultiplicity = tagMultiplicity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    //</editor-fold>
}
