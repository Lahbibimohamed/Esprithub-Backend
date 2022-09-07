package com.ssd.esprithub.controller;

import com.ssd.esprithub.entity.User;
import com.ssd.esprithub.repository.UserRepository;
import com.ssd.esprithub.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    @PutMapping("update/{id}")
    public User update(@RequestBody User user, @PathVariable("id") Long id) {
        User updatedUser = userService.update(user, id);
        return updatedUser;
    }
    @PutMapping("managment/changeRole/{id}")
    public User ChangeRole(@RequestBody User user, @PathVariable("id") Long id) {
        User changeRole = userService.changeROle(user, id);
        return changeRole;
    }


    @DeleteMapping("managment/delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        userService.delete(id);
    }
    @GetMapping("managment/findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
    @GetMapping("list")
    public List<User> findAll() {
        return userService.findAll();
    }
        @GetMapping("managment/getrole/{id}")
    public String getrole(@PathVariable("id") Long id) {
        return userService.getRole(id);
    }

    @GetMapping("managment/getbyemail/{id}")
    public String getuserbyEmail(@PathVariable("id") Long id) {
        return userService.getRole(id);
    }



    @PostMapping("/insertImage/{id}")
    public String updateImage(@RequestParam("File") MultipartFile file,@PathVariable("id") Long id ) throws IOException {

        File myFile = new File("/home/mohamed/Esprithub/src/assets/img/avatars/"+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(myFile);
        fos.write(file.getBytes());
        User u = userRepository.findById(id).get();
        u.setImage("assets/img/avatars/"+file.getOriginalFilename());
        userRepository.save(u);
        fos.close();
        return "The File Uploaded Successfully";
    }
}
