package com.project.dto;

public class ResponseUserDTO {
    public ResponseUserDTO(String email, String fio, String message) {
        this.email = email;
        this.fio = fio;
        this.message = message;
    }

    String email;
    String fio;
    String message;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
