package com.soar.common.specurity.useDetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/9/7 0007.
 */
public class UserDetailServiceImpl implements UserDetailService {

    public UserDetails loadUserByUsername(String username, String password,int userType) throws UsernameNotFoundException {
        //MyUsertails userDetails = new MyUsertails(username,password,getAuthorities());
        //userDetails.setUserType(userType);
        //return userDetails;
        UserDetails userDetails = new User(username,password,getAuthorities());
        return userDetails;
    }



    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authList;
    }
}
