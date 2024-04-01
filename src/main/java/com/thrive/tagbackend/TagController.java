package com.thrive.tagbackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @RequestMapping
    public String helloWorld() {
        return "Hello, World!";
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye, World!";
    }
}
