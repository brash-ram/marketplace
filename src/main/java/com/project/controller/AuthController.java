package com.project.controller;

import com.project.entity.User;
import com.project.service.UserService;
import com.project.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/registration")
	public ResponseUser addUser(@RequestBody RequestRegistration userForm) {
		return userService.saveUser(userForm);

	}

	@PostMapping("/login")
	public ResponseUser loadUser(@RequestBody RequestAuthorization userForm) {
		return userService.loadUser(userForm);
	}
}
