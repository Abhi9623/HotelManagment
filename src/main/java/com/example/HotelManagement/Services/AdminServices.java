package com.example.HotelManagement.Services;

import com.example.HotelManagement.Models.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<Hotel> PostHotels(Hotel hotel){
        Hotel hotel1=Hotel.builder().hotelName(hotel.getHotelName()).description(hotel.getDescription())
                .location(hotel.getLocation()).availabilities(hotel.getAvailabilities()).build();

        hotelRepository.save(hotel1);

         return ResponseEntity.ok(hotel1);

    }
}
