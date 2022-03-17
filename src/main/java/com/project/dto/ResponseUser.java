package com.project.dto;

public class ResponseUser {
    public ResponseUser(Long id, String email, String username, String fio, String message) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fio = fio;
        this.message = message;
    }

    Long id;
    String email;
    String username;
    String fio;
    String message;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
