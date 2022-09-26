package com.ssd.esprithub.service.user;

import com.ssd.esprithub.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    User update(User user, Long id);
    void delete(long id);
    List<User> findAll();
    User findById(Long id);
    String getRole(Long id ) ;
    User changeROle ( User user,Long id );
    User finduserbytoken(String email);
    Map<String, String> changePassword (String newPassword , String oldpassword , Long id);
    Long countUsers();
  Long usersByday ();
  Long listuserByrRoleUser();
    Long listuserByrRoleTeacher();
    List getUserPerMonth();

}
