package com.ssd.esprithub.service.user;

import com.ssd.esprithub.entity.Options;
import com.ssd.esprithub.entity.User;
import com.ssd.esprithub.repository.UserRepository;
import com.ssd.esprithub.service.options.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final LocalDateTime now= LocalDateTime.now();
   private final LocalDateTime yesterday= LocalDateTime.now().minusDays(1);
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
    public Map<String, String> changePassword(String newPassword, String oldpassword, Long id) {
        HashMap<String, String> map = new HashMap<>();

        if (userRepository.findById(id).isPresent()) {
            User u = userRepository.findById(id).get();
            if (bCryptPasswordEncoder.matches(oldpassword, u.getPassword())) {
                u.setPassword(bCryptPasswordEncoder.encode(newPassword));
                userRepository.save(u);
                map.put("response", "password changed Successfully");

            }else {
                map.put("response", "wrong password");
            }


    }
        return map;
    }
    public Long countUsers(){
        return userRepository.count();
    }

    @Override
    public Long usersByday() {
       return userRepository.findAllActiveUsersNative(yesterday,now).stream().count();
    }

    @Override
    public Long listuserByrRoleUser() {
        return userRepository.findUserRole("user").stream().count();
    }

    @Override
    public Long listuserByrRoleTeacher() {
        return userRepository.findUserRole("teacher").stream().count();
    }

    @Override
    public List getUserPerMonth() {
        List<User> users = userRepository.findAll();
        int jan = 0 ;
        int feb = 0 ;
        int mar = 0 ;
        int apr = 0 ;
        int may = 0 ;
        int jun = 0 ;
        int july = 0 ;
        int aug = 0 ;
        int sep = 0 ;
        int oct = 0 ;
        int nov = 0 ;
        int dec = 0 ;

        for (User user : users) {
            if( user.getCreatedat().getMonth().name()=="JANUARY"){
                jan=jan+1;
            }
            if( user.getCreatedat().getMonth().name()=="FEBRUARY"){
                feb=feb+1;
            } if( user.getCreatedat().getMonth().name()=="MARCH"){
                mar=mar+1;
            } if( user.getCreatedat().getMonth().name()=="APRIL"){
                apr=apr+1;
            } if( user.getCreatedat().getMonth().name()=="MAY"){
                may=may+1;
            } if( user.getCreatedat().getMonth().name()=="JUNE"){
                jun=jun+1;
            } if( user.getCreatedat().getMonth().name()=="JULY"){
                july=july+1;
            } if( user.getCreatedat().getMonth().name()=="AUGUST"){
                aug=aug+1;
            }
            if( user.getCreatedat().getMonth().name()=="SEPTEMBER"){
                sep=sep+1;
            } if( user.getCreatedat().getMonth().name()=="OCTOBER"){
                oct=oct+1;
            } if( user.getCreatedat().getMonth().name()=="NOVEMBER"){
                nov=nov+1;
            } if( user.getCreatedat().getMonth().name()=="DECEMBER"){
                dec=dec+1;
            }
        }
        List usersPermonth = new ArrayList();
        usersPermonth.add(jan);
        usersPermonth.add(feb);
        usersPermonth.add(mar);
        usersPermonth.add(apr);
        usersPermonth.add(may);
        usersPermonth.add(jun);
        usersPermonth.add(july);
        usersPermonth.add(aug);
        usersPermonth.add(sep);
        usersPermonth.add(oct);
        usersPermonth.add(nov);
        usersPermonth.add(dec);
        return usersPermonth;
    }


}
