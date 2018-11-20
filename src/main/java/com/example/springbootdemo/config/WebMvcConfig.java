package com.example.springbootdemo.config;

import com.example.springbootdemo.filter.LoginFilter;
import com.example.springbootdemo.interceptor.MyInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
// @ComponentScan("com.example.springbootdemo.controller")
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/index").setViewName("index");
    }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     System.out.println("-------this is interceptor----------");
    //     registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/register");
    // }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loginFilter");
        return registration;
    }
}
