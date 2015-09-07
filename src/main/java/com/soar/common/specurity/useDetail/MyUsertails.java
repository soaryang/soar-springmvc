package com.soar.common.specurity.useDetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2015/9/7 0007.
 */
public class MyUsertails extends User implements UserDetails {

    private int userType;

    public MyUsertails(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, new ArrayList<GrantedAuthority>());
    }


    //自定义构造函数

    /**
     *
     * @param username
     * @param password
     * @param authorities
     * @param userType 用户类型
     */
    public MyUsertails(String username, String password, Collection<GrantedAuthority> authorities,int userType) {
        //super(username, password, new ArrayList<GrantedAuthority>());
        //this.userType = userType;
        super(username, password, true, true, true, true, authorities);
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
