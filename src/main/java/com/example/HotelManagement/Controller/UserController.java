package com.example.HotelManagement.Controller;


import com.example.HotelManagement.Models.User;
import com.example.HotelManagement.ResponceBodyAll.LoginBody;
import com.example.HotelManagement.ResponceBodyAll.ResponceBodyToken;
import com.example.HotelManagement.Services.UserAppServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAppServices userAppServices;

    @PostMapping("/register")
    public ResponceBodyToken Register(@Valid @RequestBody User user){
        return userAppServices.Register(user);
    }

    @PostMapping("/login")
    public ResponceBodyToken Login(@RequestBody LoginBody loginBody){
        return userAppServices.Login(loginBody);
    }
}
