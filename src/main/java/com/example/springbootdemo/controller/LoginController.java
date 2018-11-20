package com.example.springbootdemo.controller;


import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
@Api(value = "Login" ,description = "登陆注册")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String Registration(User user){

        User temp = userService.findByUsername(user.getUsername());
        System.out.println("----------" + user + "-------------");

        //比较username
        if (temp != null) {
            return "login";
        }else {
            userService.addUser(user);
            return "login";
        }
    }

    @PostMapping(value = "/login")
    public String Login(User user, HttpSession session) {
        System.out.println("----------" + user + "-------------");
        User temp = userService.findByUsername(user.getUsername());

        if (temp != null) {
            if (temp.getPassword().equals(user.getPassword())) {
                System.out.println("登陆成功");
                session.setAttribute("user", user);
                return "login";
            }
        }

        return "login";
    }

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") long id) {
        return userService.findById(id);
    }
}
