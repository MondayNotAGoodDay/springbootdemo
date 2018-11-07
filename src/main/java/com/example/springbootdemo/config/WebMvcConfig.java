package com.example.springbootdemo.config;

import com.example.springbootdemo.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan("com.example.springbootdemo.controller")
public class WebMvcConfig implements WebMvcConfigurer {

    //@Override
    //public void addViewControllers(ViewControllerRegistry registry) {
    //    registry.addViewController("/").setViewName("index");
    //}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }


}
