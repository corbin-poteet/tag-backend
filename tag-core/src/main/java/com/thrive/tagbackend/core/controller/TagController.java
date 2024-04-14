package com.thrive.tagbackend.core.controller;

import com.thrive.tagbackend.core.model.Tag;
import com.thrive.tagbackend.core.service.TagService;
import io.nats.client.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.thrive.tagbackend.core.TagBackendApplication.ARGS;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    private final TagService tagService;
    private final RedisTemplate<String, Tag> redisTemplate;
    private Connection compositingServiceConnection;
    private JetStream compositingServiceJetStream;

    public TagController(TagService tagService) {
        this.tagService = tagService;
        this.redisTemplate = new RedisTemplate<>();


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
        // First persist (blocking) the new Tag to your existing SQL database
        String result = tagService.createTag(tag);

        // Then dispatch (asynchronously) a compositing task to your new compositing system as described below
        dispatchAsyncCompositingTask(tag);



        return result;
    }

    private void dispatchAsyncCompositingTask(Tag tag) {
        System.out.println("Dispatching compositing task");

        System.out.println("ARGS: " + Arrays.toString(ARGS));
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
