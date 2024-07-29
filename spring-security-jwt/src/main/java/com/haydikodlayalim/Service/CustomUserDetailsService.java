package com.haydikodlayalim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  DummyUserService dummyUserService;
    
   
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dummyUserService.getUserByUsername(username);
    }
}