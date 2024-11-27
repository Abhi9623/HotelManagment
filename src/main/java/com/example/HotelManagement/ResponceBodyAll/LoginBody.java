package com.example.HotelManagement.ResponceBodyAll;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginBody {

    private  String email;
    private  String password;
}
