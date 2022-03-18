package com.project.service;

import com.project.entity.Role;
import com.project.entity.User;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.dto.*;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public ResponseUserDTO loadUser(RequestAuthorizationDTO userForm) {
        User user = userRepository.findByUsername(userForm.getUsername());

        ResponseUserDTO response = new ResponseUserDTO(null, null, null, null,
                "userNotFound");
        if (user != null) {
            if (bCryptPasswordEncoder.matches(userForm.getPassword(), user.getPassword())) {
                response = new ResponseUserDTO(user.getId(), user.getEmail(), user.getUsername(), user.getFio(),
                        "authorizationSuccessful");
            }
        }

        return response;
    }

    public ResponseUserDTO saveUser(RequestRegistrationDTO userForm) {
        roleRepository.save(new Role(1L, "ROLE_USER"));
        User userFromDB = userRepository.findByUsername(userForm.getUsername());
        ResponseUserDTO response = new ResponseUserDTO(null, null, null, null,
                "userFound");

        if (userFromDB == null) {
            User user = new User();
            user.setUsername(userForm.getUsername());
            user.setEmail(userForm.getEmail());
            user.setFio(userForm.getFio());
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);

            User loadUser = userRepository.findByUsername(userForm.getUsername());
            response = new ResponseUserDTO(loadUser.getId(), userForm.getEmail(), userForm.getUsername(), userForm.getFio(),
                    "registrationSuccessful");
        }
        return response;
    }

}
