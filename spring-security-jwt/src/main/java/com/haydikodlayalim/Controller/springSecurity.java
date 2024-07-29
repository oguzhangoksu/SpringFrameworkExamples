package com.haydikodlayalim.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class springSecurity {


    @GetMapping("/springSecurity")
    public String springSecurity() {
        return "Spring Security";
    }
    
}
