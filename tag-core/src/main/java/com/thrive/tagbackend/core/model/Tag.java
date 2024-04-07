package com.thrive.tagbackend.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag_info")
public class Tag {
    @Id
    private String groupAndElement; // group + ", " + element, both in hex
    private String studyId;
    private String seriesId;
    private String instanceId;
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

    public String getStudyId() {
        return studyId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public String getValueRepresentation() {
        return valueRepresentation;
    }

    public String getTagLength() {
        return tagLength;
    }

    public String getTagMultiplicity() {
        return tagMultiplicity;
    }

    public String getValue() {
        return value;
    }

    public int getGroup() {
        return group;
    }

    public int getElement() {
        return element;
    }

    public boolean isEditable() {
        return editable;
    }
//</editor-fold>

    //<editor-fold desc="Setters">
    public void setGroupAndElement(String groupAndElement) {
        this.groupAndElement = groupAndElement;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public void setValueRepresentation(String valueRepresentation) {
        this.valueRepresentation = valueRepresentation;
    }

    public void setTagLength(String tagLength) {
        this.tagLength = tagLength;
    }

    public void setTagMultiplicity(String tagMultiplicity) {
        this.tagMultiplicity = tagMultiplicity;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
//</editor-fold>
}
