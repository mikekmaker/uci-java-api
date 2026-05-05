package com.pv.api.application.dto;

public class ErrorResponse {

    private String detail;

    public ErrorResponse(String detail) {
        this.detail = detail;
    }

    public String getDetail() { return detail; }
}