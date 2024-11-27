package com.example.HotelManagement.Services;

import com.example.HotelManagement.Exceptions.ResourceNotFoundException;
import com.example.HotelManagement.Models.Booking;
import com.example.HotelManagement.Models.Hotel;
import com.example.HotelManagement.Models.User;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.UserRepository;
import com.example.HotelManagement.ResponceBodyAll.Bodyforbooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ResponseEntity<Booking> BookHotel(Bodyforbooking bodyforbooking){
        User user = userRepository.findById(Long.parseLong(bodyforbooking.getUserid())).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Hotel hotel = hotelRepository.findById(Long.parseLong(bodyforbooking.getHotelid())).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));

        // Create a new booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setHotel(hotel);
        user.getBookingList().add(booking);
        hotel.getBookingList().add(booking);
        userRepository.save(user);
        hotelRepository.save(hotel);


        // Save the booking and return
         bookingRepository.save(booking);

         return  ResponseEntity.ok(booking);
    }
}
