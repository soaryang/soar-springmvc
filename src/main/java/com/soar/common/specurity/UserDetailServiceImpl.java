package com.soar.common.specurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/9/7 0007.
 */
public class UserDetailServiceImpl implements UserDetailService {

    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
        MyUsertails userDetails = new MyUsertails(username,password,getAuthorities());
        return userDetails;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new GrantedAuthority() {
            public String getAuthority() {
                return "ROLE_USER";
            }
        });
        return authList;
    }
}
