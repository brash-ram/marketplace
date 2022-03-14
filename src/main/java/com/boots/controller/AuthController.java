package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	public String addUser(@Valid User userForm) {

		if (!userService.saveUser(userForm)){
			return "usernameError";
		}

		return "true";
	}

	@PostMapping("/login")
	public String loadUser(@Valid User userForm) {
		System.out.println("Load");
		try {
			User loadUser = userService.loadUserByUsername(userForm.getUsername());
		}
		catch (UsernameNotFoundException exception){
			return "UsernameNotFound";
		}
		return "true";
	}
}
