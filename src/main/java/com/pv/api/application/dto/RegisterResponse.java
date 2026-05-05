package com.pv.api.application.dto;

public class RegisterResponse {

    private String msg;

    public RegisterResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() { return msg; }
}