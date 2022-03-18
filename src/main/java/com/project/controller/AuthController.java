package com.project.controller;

import com.project.service.UserService;
import com.project.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	public ResponseUserDTO addUser(@RequestBody RequestRegistrationDTO userForm) {
		return userService.saveUser(userForm);

	}

	@PostMapping("/login")
	public ResponseUserDTO loadUser( RequestAuthorizationDTO userForm) {
		return userService.loadUser(userForm);
	}
}
