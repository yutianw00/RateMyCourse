package com.example.projserver.dto;

/*
 LoginDTO: the data transfer object FROM the springboot server TO the frontend Vue application
 */
public class LoginDTO {
    private int code;
    private String message;

    public LoginDTO() {
    }

    public LoginDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
