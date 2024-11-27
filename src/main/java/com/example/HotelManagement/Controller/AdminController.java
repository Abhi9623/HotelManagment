package com.example.HotelManagement.Controller;


import com.example.HotelManagement.Models.Hotel;
import com.example.HotelManagement.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
   private AdminServices adminServices;


     @PostMapping("/post-hotes")
     @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Hotel> PostHotels(@RequestBody Hotel hotel){
         return  adminServices.PostHotels(hotel);

    }
}
