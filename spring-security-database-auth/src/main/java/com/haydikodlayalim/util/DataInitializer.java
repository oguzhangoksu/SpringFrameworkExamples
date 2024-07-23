package com.haydikodlayalim.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.haydikodlayalim.Repository.RoleRepository;
import com.haydikodlayalim.Repository.UserRepository;
import com.haydikodlayalim.entity.Role;
import com.haydikodlayalim.entity.User;

import jakarta.transaction.Transactional;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @Transactional
    public CommandLineRunner loadData() {
        return args -> {
            // Create roles
            Role adminRole = roleRepository.findByRoleName("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRoleName("ADMIN");
                roleRepository.save(adminRole);
            }
            Role userRole = roleRepository.findByRoleName("USER");
            if (userRole == null) {
                userRole = new Role();
                userRole.setRoleName("USER");
                roleRepository.save(userRole);
            }

            // Create admin user
            if (userRepository.findByUsername("admin")==null) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("123456789"));
                List<Role> adminRoles = new ArrayList<>();
                adminRoles.add(adminRole);
                adminUser.setRoles(adminRoles);
                userRepository.save(adminUser);
            }
            if (userRepository.findByUsername("user")==null) {
            // Create regular user
                User regularUser = new User();
                regularUser.setUsername("user");
                regularUser.setPassword(passwordEncoder.encode("123456789"));
                List<Role> userRoles = new ArrayList<>();
                userRoles.add(userRole);
                regularUser.setRoles(userRoles);
                userRepository.save(regularUser);
            }
        };
    }
    
}