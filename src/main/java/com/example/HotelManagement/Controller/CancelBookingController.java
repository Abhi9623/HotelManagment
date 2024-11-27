package com.example.HotelManagement.Controller;


import com.example.HotelManagement.Models.Booking;
import com.example.HotelManagement.Models.Hotel;
import com.example.HotelManagement.ResponceBodyAll.Bodyforbooking;
import com.example.HotelManagement.ResponceBodyAll.CancelBookingBody;
import com.example.HotelManagement.ResponceBodyAll.ResponceBodyToken;
import com.example.HotelManagement.Services.CancelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cancel")
public class CancelBookingController {

    @Autowired
    private CancelServices cancelServices;

    @PostMapping("/booking")
    @PreAuthorize("hasAuthority('HOTELMANAGER')")
    public ResponseEntity<Booking> PostHotels(@RequestBody CancelBookingBody cancelBookingBody){
        return   cancelServices.Cancel(cancelBookingBody);

    }
}
