package com.mutliuser.multiuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutliuser.multiuser.models.User;
import com.mutliuser.multiuser.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public User Register(@RequestBody User user) {
		return authService.register(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		return  authService.login(user);
	}

}
