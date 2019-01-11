package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
// @ComponentScan("com.example.springbootdemo.controller")
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/index").setViewName("index");
    }
}
