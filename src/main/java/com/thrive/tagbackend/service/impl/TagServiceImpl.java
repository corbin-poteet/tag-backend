package com.thrive.tagbackend.service.impl;

import com.thrive.tagbackend.TagUtils;
import com.thrive.tagbackend.repository.TagRepository;
import com.thrive.tagbackend.service.TagService;
import com.thrive.tagbackend.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TagServiceImpl implements TagService {
    @Autowired(required = false)
    private TagRepository tagRepository;


    @Override
    public String createTag(Tag tag) {
        // Set groupAndElement if not set
        if (tag.getGroupAndElement() == null) {
            tag.setGroupAndElement(TagUtils.getGroupAndElement(tag.getGroup(), tag.getElement()));
        }

        // Check if tag already exists
        if (tagRepository.existsById(tag.getGroupAndElement())) {
            return "Tag already exists";
        }

        // Check if groupAndElement matches group and element
        if (!Objects.equals(tag.getGroupAndElement(), TagUtils.getGroupAndElement(tag.getGroup(), tag.getElement()))) {
            return "Group and element do not match";
        }

        tagRepository.save(tag);
        return "Success";
    }

    @Override
    public String updateTag(Tag tag) {
        if (!tagRepository.existsById(tag.getGroupAndElement())) {
            return "Tag does not exist";
        }

        // Check if groupAndElement matches group and element
        if (!Objects.equals(tag.getGroupAndElement(), TagUtils.getGroupAndElement(tag.getGroup(), tag.getElement()))) {
            return "Group and element do not match";
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
