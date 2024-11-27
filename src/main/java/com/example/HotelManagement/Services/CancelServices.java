package com.example.HotelManagement.Services;

import com.example.HotelManagement.Exceptions.ResourceNotFoundException;
import com.example.HotelManagement.Models.Booking;
import com.example.HotelManagement.Models.Hotel;
import com.example.HotelManagement.Models.User;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.UserRepository;
import com.example.HotelManagement.ResponceBodyAll.Bodyforbooking;
import com.example.HotelManagement.ResponceBodyAll.CancelBookingBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CancelServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ResponseEntity<Booking> Cancel(CancelBookingBody cancelBookingBody){
        User user = userRepository.findById(Long.parseLong(cancelBookingBody.getUserid())).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Booking booking= bookingRepository.findById(Long.parseLong(cancelBookingBody.getBookingId())).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
        Hotel hotel = hotelRepository.findById(Long.parseLong(cancelBookingBody.getHotelId())).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
        // Create a new booking

        user.getBookingList().remove(booking);
        hotel.getBookingList().remove(booking);
        userRepository.save(user);
        hotelRepository.save(hotel);


        // Save the booking and return


        return  ResponseEntity.ok(booking);
    }
}
