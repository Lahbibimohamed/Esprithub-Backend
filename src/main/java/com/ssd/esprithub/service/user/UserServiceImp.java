package com.ssd.esprithub.service.user;

import com.ssd.esprithub.entity.Options;
import com.ssd.esprithub.entity.User;
import com.ssd.esprithub.repository.UserRepository;
import com.ssd.esprithub.service.options.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final OptionService optionService;
    private final UserRepository userRepository;

    @Override
    public User update(User user, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmail(user.getEmail());
            u.setGender(user.getGender());
            u.setNiveau(user.getNiveau());
            u.setAddress(user.getAddress());
            Options test = optionService.findById(user.getOption_id().getIdOption());
            u.setOption_id(test);
            u.setAboutMe(user.getAboutMe());
            return userRepository.save(u);

        }
        return null;


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
    public String getRole(Long id) {
        User user = userRepository.findById(id).get();
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

    @Override
    public User finduserbytoken(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public String changePassword(String oldpassword, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            if(bCryptPasswordEncoder.matches(oldpassword.toString(), u.getPassword())){
                return "true";
            }else {
                return oldpassword;
            }


        }
        return "false";    }

}
