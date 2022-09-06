package com.ssd.esprithub.Services;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssd.esprithub.Repositories.UserRepository;
import com.ssd.esprithub.entity.User;



@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User findByUserName(String username) {
		return repository.findByUsername(username);
	}
	
	
	public User addUser(User user) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		return repository.save(user);
	}
	public boolean verrifymail(String email) {
		User user=repository.findByEmail(email);
		return user != null;
		
	}
	
	public boolean verrifyUsername(String username) {
		User user=repository.findByUsername(username);
		return user != null;
	}

}
