package com.mutliuser.multiuser.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutliuser.multiuser.models.User;
import com.mutliuser.multiuser.repostory.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Base64.Encoder base64encoder = Base64.getUrlEncoder(); 

	public User register(User user) {
		
	 if(checkUserExist(user)==true)
		 return null;
	 user.setToken(generatetoken());
	 
	 return userRepository.save(user);
	 
	}

	private String generatetoken() {
		byte[] token = new byte[24];
		secureRandom.nextBytes(token);
		return base64encoder.encodeToString(token);	
	}

	private boolean checkUserExist(User user) {
		User existngUser = userRepository.findById(user.getUsername()).orElse(null);
		if (existngUser == null) {
			return false;
		}
		return true;
	}

	public User login(User user) throws Exception {
		User existngUser = userRepository.findById(user.getUsername()).orElseThrow(() -> new Exception());
		
		  if (existngUser.getUsername().equals(user.getUsername()) && existngUser.getPassword().equals(user.getPassword())&& existngUser.getRole().equals(user.getRole())) {
			 existngUser.setPassword("");
			 return existngUser;
		}
		return null;
}
}
