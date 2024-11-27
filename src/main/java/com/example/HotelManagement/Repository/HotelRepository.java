package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface HotelRepository extends JpaRepository<Hotel,Long> {
}
