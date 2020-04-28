package com.cloud.integratedSystem.auth;

import com.cloud.integratedSystem.auth.entities.CustomUserDetails;
import com.cloud.integratedSystem.auth.entities.User;
import com.cloud.integratedSystem.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Set<String> roles = userService.findRolesByUserName(user.getUserName());
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setId(user.getUserId());
        customUserDetails.setRoles("");
        customUserDetails.setUserName(user.getUserName());
        customUserDetails.setPassword(user.getPassword());
        customUserDetails.setEnable(true);
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        customUserDetails.setAuthorities(authorities);
        return customUserDetails;

    }
}
