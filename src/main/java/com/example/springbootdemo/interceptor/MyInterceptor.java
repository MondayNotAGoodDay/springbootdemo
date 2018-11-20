package com.example.springbootdemo.interceptor;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        String uri = request.getRequestURI();

        //如果请求uri不是login，则要过滤
        if (!uri.contains("login")) {
            boolean isLogin = (boolean) session.getAttribute("isLogin");
            //如果没登陆过，就重定向到登陆页面
            if (!isLogin) {
                response.sendRedirect("login.html");
                return false;
            }
        }
        return true;
    }

}
