package com.soar.common.specurity.useDetail;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by user on 15/9/6.
 */
public interface  UserDetailService {


    UserDetails loadUserByUsername(String username, String password,int userType) throws UsernameNotFoundException;
}
