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

    @PostMapping("/uploadimage")
    public String uploadimage (@RequestParam ("file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        String Path_directory="src/main/resources/images";

        return "test";
    }

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;
    @PostMapping("/uploadFile")
    public String updateImage(@RequestParam("File") MultipartFile file) throws IOException{
        File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return "The File Uploaded Successfully";
    }
}

