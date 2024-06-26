package com.thrive.tagbackend.core.controller;

import com.thrive.tagbackend.core.model.Tag;
import com.thrive.tagbackend.core.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{group}/{element}")
    public Tag getTag(@PathVariable("group") int group, @PathVariable("element") int element) {
        return tagService.getTag(group, element);
    }

    @GetMapping()
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping()
    public String createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @PutMapping()
    public String updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }

    @DeleteMapping("/{group}/{element}")
    public String deleteTag(@PathVariable("group") int group, @PathVariable("element") int element) {
        return tagService.deleteTag(group, element);
    }

    @DeleteMapping()
    public String deleteAllTags() {
        return tagService.deleteAllTags();
    }
}
