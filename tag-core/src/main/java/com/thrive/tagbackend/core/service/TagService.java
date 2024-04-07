package com.thrive.tagbackend.core.service;

import com.thrive.tagbackend.core.model.Tag;

import java.util.List;
public interface TagService {
    public String createTag(Tag tag);
    public String updateTag(Tag tag);
    public String deleteTag(String groupAndElement);
    public String deleteTag(int group, int element);
    public Tag getTag(String groupAndElement);
    public Tag getTag(int group, int element);
    public List<Tag> getAllTags();
    public String deleteAllTags();
}
