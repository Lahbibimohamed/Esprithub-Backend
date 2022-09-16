package com.ssd.esprithub.service.user;

import com.ssd.esprithub.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User update(User user, Long id);
    void delete(long id);
    List<User> findAll();
    User findById(Long id);
    String getRole(Long id ) ;
    User changeROle ( User user,Long id );
    User finduserbytoken(String email);
    String changePassword (String oldpassword ,Long id);

}
