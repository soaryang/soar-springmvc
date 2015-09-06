package com.soar.common.specurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2015/9/7 0007.
 */
public class MyUsertails extends User implements UserDetails {

    public MyUsertails(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, new ArrayList<GrantedAuthority>());
    }
}
