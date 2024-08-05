package com.haydikodlayalim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haydikodlayalim.Service.abstracts.IUserService;
import com.haydikodlayalim.entity.User;

import jakarta.annotation.PostConstruct;

import java.util.Calendar;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    //Fake data
    @PostConstruct
    public void init(){
        User user=new User();
        user.setName("oğuzhan");
        user.setSurname("göksu");
        user.setAddress("Bursa");
        user.setBirthDate(Calendar.getInstance().getTime());
        userService.save(user);

    }
         

    @GetMapping("/get/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {
        List<User> users=userService.findByNameLikeOrSurnameLike(search);

        return ResponseEntity.ok(users);

        
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        userService.deleteById(id);

        return ResponseEntity.ok("user deleted :" +id);

        
    }


    
    
  

    
}
