package com.enterName.marketplace.User;

public class Authorizator {

    public User authorization(User userData) {
        User user = new User("log", "pass", "firstName lastName", "mail@mail.ru");

        if (userData.getLogin() == user.getLogin() && userData.getPassword() == user.getPassword()) {
            return user;
        }
        return null;
    }
}
