package com.example.HotelManagement.Controller;

import com.example.HotelManagement.Exceptions.ResourceNotFoundException;
import com.example.HotelManagement.Models.Booking;
import com.example.HotelManagement.ResponceBodyAll.Bodyforbooking;
import com.example.HotelManagement.Services.BookingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
  private BookingServices bookingServices;

    @PostMapping("/hotel")
    public ResponseEntity<Booking> bookHotel(@RequestBody Bodyforbooking bodyforbooking) {
        // Fetch the user from the repository (just an example)
        log.info("Request came");

        return bookingServices.BookHotel(bodyforbooking);

    }
}
