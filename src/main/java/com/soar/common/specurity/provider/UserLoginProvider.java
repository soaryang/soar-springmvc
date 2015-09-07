package com.soar.common.specurity.provider;

import com.soar.common.specurity.token.MyAuthenticationToken;
import com.soar.common.specurity.useDetail.UserDetailService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by user on 15/9/6.
 */
public class UserLoginProvider extends AbstractUserDetailsAuthenticationProvider {

    private UserDetailService userDetailService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        String password = (String) usernamePasswordAuthenticationToken.getCredentials();
        MyAuthenticationToken myAuthenticationToken = (MyAuthenticationToken)usernamePasswordAuthenticationToken;
        UserDetails loadedUser = getUserDetailService().loadUserByUsername(username,password,myAuthenticationToken.getUserType());
        return loadedUser;
    }


    public UserDetailService getUserDetailService() {
        return userDetailService;
    }

    public void setUserDetailService(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
}
