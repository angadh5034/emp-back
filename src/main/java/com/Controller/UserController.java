package com.Controller;

import com.Dto.Userdto;
import com.Service.Userservice;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    Userservice service;
    @PostMapping("/new/register")
    public String register(@RequestBody User u){
        return service.register(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Userdto udto){
        User existinuser=service.login(udto);
        if(existinuser!=null){
            return ResponseEntity.ok(existinuser);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
}