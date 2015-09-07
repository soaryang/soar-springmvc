package com.soar.common.specurity.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.security.auth.Subject;

/**
 * Created by user on 15/9/7.
 */
public class MyAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private int userType;

    public MyAuthenticationToken(Object principal, Object credentials,int userType) {
        super(principal, credentials);
        this.userType =userType;
    }

    public MyAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
