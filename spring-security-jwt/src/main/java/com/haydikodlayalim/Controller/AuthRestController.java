package com.haydikodlayalim.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haydikodlayalim.Service.CustomUserDetailsService;
import com.haydikodlayalim.Util.AuthRequest;
import com.haydikodlayalim.Util.JwtUtil;

@RestController
public class AuthRestController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public String creteToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            System.out.println(authRequest.getUsername()+"+"+ authRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorret username or password", ex);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        System.out.println("UserDetails:"+userDetails);
        final String jwt = jwtUtil.generateToken(userDetails);
        System.out.println("JWT:"+jwt);
        System.out.println("UserDetails2:"+userDetails);

        return jwt;
    }
}