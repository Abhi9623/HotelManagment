package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

     User findByEmail(String email);
}
