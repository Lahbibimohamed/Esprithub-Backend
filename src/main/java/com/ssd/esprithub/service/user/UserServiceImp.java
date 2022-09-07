package com.ssd.esprithub.service.user;

import com.ssd.esprithub.entity.User;
import com.ssd.esprithub.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
@Service

@AllArgsConstructor
public class UserServiceImp implements UserService{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private  final UserRepository userRepository;
    @Override
    public User update(User user, Long id) {
            if( userRepository.findById(id ).isPresent()){
            User u = userRepository.findById(id).get();
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setAddress(user.getAddress());
            u.setAboutMe(user.getAboutMe());
            u.setNiveau(user.getNiveau());
            u.setRole(user.getRole());

                if (user.getPassword() !=null){
                String encodedPassword=   bCryptPasswordEncoder.encode( user.getPassword());
                u.setPassword(encodedPassword);
            }
            u.setGender(user.getGender());

                return userRepository.save(u);

            }
            return  null ;



    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String getRole( Long id ) {
        User user= userRepository.findById(id ).get();
        String role = user.getRole().name();
        return role;
    }

    @Override
    public User changeROle(User user, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            u.setRole(user.getRole());
            userRepository.save(u);
            return u;
        }
        return null;
    }
/*
    @Override
   public User updatephoto(MultipartFile file, User user) {
        File myFile = new File("/home/mohamed/Esprithub-Backend/src/main/resources/images"+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return "The File Uploaded Successfully";    }*/


}
