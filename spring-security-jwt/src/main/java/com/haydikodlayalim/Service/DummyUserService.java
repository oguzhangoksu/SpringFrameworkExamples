package com.haydikodlayalim.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DummyUserService {

    private Map<String, User> users = new HashMap<>();
    @Autowired
    private PasswordEncoder passwordEncoder;

   

    @PostConstruct
    public void initialize() {
        users.put("oguzhan", new User("oguzhan", passwordEncoder.encode("123"),new ArrayList<>()));
        users.put("metin", new User("metin", passwordEncoder.encode("123"),new ArrayList<>()));
        users.put("dilek", new User("dilek", passwordEncoder.encode("123"),new ArrayList<>()));
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }
}