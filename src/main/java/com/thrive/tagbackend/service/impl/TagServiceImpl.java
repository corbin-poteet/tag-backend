package com.thrive.tagbackend.service.impl;

import com.thrive.tagbackend.TagUtils;
import com.thrive.tagbackend.repository.TagRepository;
import com.thrive.tagbackend.service.TagService;
import com.thrive.tagbackend.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public String createTag(Tag tag) {
        if (tagRepository.existsById(tag.getGroupAndElement())) {
            return "Tag already exists";
        }

        tagRepository.save(tag);
        return "Success";
    }

    @Override
    public String updateTag(Tag tag) {
        if (!tagRepository.existsById(tag.getGroupAndElement())) {
            return "Tag does not exist";
        }

        tagRepository.save(tag);
        return "Success";
    }

    @Override
    public String deleteTag(String groupAndElement) {
        if (!tagRepository.existsById(groupAndElement)) {
            return "Tag does not exist";
        }

        tagRepository.deleteById(groupAndElement);
        return "Success";
    }

    @Override
    public String deleteTag(int group, int element) {
        String groupAndElement = TagUtils.getGroupAndElement(group, element);
        return deleteTag(groupAndElement);
    }

    @Override
    public Tag getTag(String groupAndElement) {
        return tagRepository.findById(groupAndElement).orElse(null);
    }

    @Override
    public Tag getTag(int group, int element) {
        String groupAndElement = TagUtils.getGroupAndElement(group, element);
        return getTag(groupAndElement);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

}
