package com.thrive.tagbackend.controller;

import com.thrive.tagbackend.TagUtils;
import com.thrive.tagbackend.model.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagAPIService {
    private Tag tag;

    @GetMapping("/{group}/{element}")
    public Tag getTag(@PathVariable int group, @PathVariable int element) {
        String groupAndElement = TagUtils.getGroupAndElement(group, element);
        return tag;
    }

    @PostMapping()
    public String createTag(@RequestBody Tag tag) {
        this.tag = tag;
        return "Tag created successfully!";
    }

    @PutMapping()
    public String updateTag(@RequestBody Tag tag) {
        this.tag = tag;
        return "Tag updated successfully!";
    }

    @DeleteMapping("/{group}/{element}")
    public String deleteTag(@PathVariable int group, @PathVariable int element) {
        String groupAndElement = TagUtils.getGroupAndElement(group, element);

        this.tag = null;
        return "Tag deleted successfully!";
    }
}
