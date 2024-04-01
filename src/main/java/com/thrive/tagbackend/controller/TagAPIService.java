package com.thrive.tagbackend.controller;

import com.thrive.tagbackend.model.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagAPIService {

    @GetMapping("/{group}/{element}")
    public Tag getTag(@PathVariable String group, @PathVariable String element) {
        return new Tag("0010,0010", "Patient's Name", "PN", "64", "1", "John Doe", 16, 16, true);
    }

    @GetMapping("/all")
    public Tag[] getAllTags() {
        return new Tag[] {
                new Tag("0010,0010", "Patient's Name", "PN", "64", "1", "John Doe", 16, 16, true),
                new Tag("0010,0020", "Patient ID", "LO", "64", "1", "12345", 16, 32, true),
                new Tag("0010,0030", "Patient's Birth Date", "DA", "8", "1", "19900101", 16, 48, true),
        };
    }
}
