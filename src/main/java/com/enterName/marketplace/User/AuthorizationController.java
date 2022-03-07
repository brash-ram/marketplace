package com.enterName.marketplace.User;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizationController {

    @PostMapping
    public void authorizationUser(@RequestBody User dataUser) {
        System.out.println(dataUser);
    }

    @GetMapping
    public boolean auth(){
        return true;
    }
}
