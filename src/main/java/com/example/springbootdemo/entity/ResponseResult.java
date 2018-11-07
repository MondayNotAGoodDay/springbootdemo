package com.example.springbootdemo.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class ResponseResult {
    //T response;
    String message;
    Integer errorCode;

    public ResponseResult(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
    //getter and setter generated by Lombok
    //hashCode and equal generated by Lombok

}