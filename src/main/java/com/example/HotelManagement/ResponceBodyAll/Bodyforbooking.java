package com.example.HotelManagement.ResponceBodyAll;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bodyforbooking {

    private  String userid;

    private String hotelid;
}
