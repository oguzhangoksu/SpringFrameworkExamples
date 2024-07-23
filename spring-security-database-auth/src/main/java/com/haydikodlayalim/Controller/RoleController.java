package com.haydikodlayalim.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping
public class RoleController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Access";
    }
    
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String userAccess() {
        return "User Access";
    }


}
