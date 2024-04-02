package com.thrive.tagbackend.service.impl;

import com.thrive.tagbackend.repository.TagRepository;
import com.thrive.tagbackend.service.TagService;
import com.thrive.tagbackend.model.Tag;
import java.util.List;

public class TagServiceImpl implements TagService {
    TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public String createTag(Tag tag) {
        return null;
    }

    @Override
    public String updateTag(Tag tag) {
        return null;
    }

    @Override
    public String deleteTag(String groupAndElement) {
        return null;
    }

    @Override
    public String deleteTag(int group, int element) {
        return null;
    }

    @Override
    public Tag getTag(String groupAndElement) {
        return null;
    }

    @Override
    public Tag getTag(int group, int element) {
        return null;
    }

    @Override
    public List<Tag> getAllTags() {
        return null;
    }

}
