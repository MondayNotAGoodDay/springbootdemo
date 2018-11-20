package com.example.springbootdemo.filter;

import com.example.springbootdemo.entity.User;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String uri = request.getRequestURI();

        boolean doFilter = true;

        String[] excludePath = {"login","register","static","swagger","v2","index"};

        //看看uri是否需要过滤
        for (String path : excludePath) {

            if(uri.contains(path) || uri.equals("/")){
                //若是login etc. ，不过滤
                doFilter = false;
                break;
            }
        }

        if (doFilter) {
            System.out.println("-------this is filter executing : need to filter ---------------" );
            //非login的就过滤，看看是否已经登陆，
            HttpSession session = request.getSession(true);
            User user = (User) session.getAttribute("user");
            System.out.println("session:user:" + user);
            if (user!=null) {
                //已登陆，放行
                System.out.println("-------this is filter executing : 放行---------------" );
                filterChain.doFilter(request, response);
            }else {
                //未登录，重定向到登陆页面
                System.out.println("--------- redirect --------------" + request.getContextPath());
                response.sendRedirect("/login");
            }
        }else {
            filterChain.doFilter(request, response);
        }

    }
}
