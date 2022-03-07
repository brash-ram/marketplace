package com.enterName.marketplace.User;

public class User {
    private long id;
    private String login;
    private String password;
    private String IO;
    private String email;

    public User(String login, String password, String IO, String email) {
        this.login = login;
        this.password = password;
        this.IO = IO;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getIO() {
        return IO;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIO(String IO) {
        this.IO = IO;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", IO='" + IO + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
