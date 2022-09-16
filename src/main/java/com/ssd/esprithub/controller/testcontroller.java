package com.ssd.esprithub.controller;

import com.ssd.esprithub.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("test/")
@CrossOrigin("*")
public class testcontroller {
    @GetMapping("test")
    public String test() {
        return
                "<h1>hello</h1>";
    }

}




