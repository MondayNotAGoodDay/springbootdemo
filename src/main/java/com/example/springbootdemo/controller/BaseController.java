package com.example.springbootdemo.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


public class BaseController {

    /**
     * 调用 /student/delete/{id} 接口时，若对应id的对象不存在，则此方法接收EmptyResultDataAccessException
     *
     * @return 错误对象
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String nonExistId() {
        //here you could return wrong messages
        //int id = (Integer) model.get("id");
        //ResponseResult responseResult = new ResponseResult("the id " + id + " not found", 4);
        return "error";
    }

    @InitBinder
    public void InitBinder(){

    }
}
