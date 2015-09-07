package com.soar.common.specurity.filter;

import com.soar.common.specurity.token.MyAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自定义登陆处理
 * Created by user on 15/9/6.
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String userType = request.getParameter("userType");
        String userType = "2";
        //UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        MyAuthenticationToken myAuthenticationToken = new MyAuthenticationToken(username,password,Integer.parseInt(userType));
        setDetails(request, myAuthenticationToken);
        return this.getAuthenticationManager().authenticate(myAuthenticationToken);
    }

}



