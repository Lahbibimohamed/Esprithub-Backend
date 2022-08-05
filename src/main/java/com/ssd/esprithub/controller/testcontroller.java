package com.ssd.esprithub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
@CrossOrigin("*")
public class testcontroller {
    @GetMapping("test")
    public String test() {
        return "<h1>hello</h1>";
    }
}
