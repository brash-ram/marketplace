package com.project.dto;

public class RequestRegistrationDTO {

    public RequestRegistrationDTO(String email, String username, String password, String fio) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.fio = fio;
    }

    private String email;
    private String username;
    private String password;
    private String fio;


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }
}
