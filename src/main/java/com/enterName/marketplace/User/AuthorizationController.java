package com.enterName.marketplace.User;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorizationController {

    @PostMapping
    public User authorizationUser(@RequestBody User userData) {
        System.out.println(userData);
        var auth = new Authorizator();
        return auth.authorization(userData);
    }

    @GetMapping
    public boolean auth(){
        return true;
    }
}
