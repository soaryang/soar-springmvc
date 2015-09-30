package com.soar.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/8/30 0030.
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----------------------------------------------MyInterceptor");
        HttpSession httpSession = request.getSession(false);


        if(httpSession!=null) {
            System.out.println("此时的SessionId 是------------>" + httpSession.getId());
        }
        /*Cookie sessionCookie =new Cookie("sessionId", "444444444444444444");
        sessionCookie.setPath("/");
        response.addCookie(sessionCookie);*/


        return true;
    }
}


