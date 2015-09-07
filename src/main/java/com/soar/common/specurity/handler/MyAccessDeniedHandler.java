package com.soar.common.specurity.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 15/9/7.
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        boolean isAjax = isAjaxRequest(request);
        if(!isAjax){
            request.setAttribute("isAjaxRequest", isAjax);
            request.setAttribute("message", accessDeniedException.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/noAuthority.html");
//            response.sendRedirect(request.getContextPath()+"/authNotPass.jsp");
            dispatcher.forward(request, response);
        }else{
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain");
            response.getWriter().write("权限不足");
            response.getWriter().close();
        }
        System.out.println("没有权限－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－》");
    }
    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header))
            return true;
        else
            return false;
    }
}
