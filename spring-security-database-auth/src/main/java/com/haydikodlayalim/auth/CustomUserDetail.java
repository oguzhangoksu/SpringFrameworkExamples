package com.haydikodlayalim.auth;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.haydikodlayalim.entity.User;

public class CustomUserDetail implements UserDetails{

    private String name;
    private String password;
    private List<GrantedAuthority> roles;
    
    public CustomUserDetail(User user) {
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return roles;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return name;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonExpired();
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return UserDetails.super.isAccountNonLocked();
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return UserDetails.super.isCredentialsNonExpired();
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
