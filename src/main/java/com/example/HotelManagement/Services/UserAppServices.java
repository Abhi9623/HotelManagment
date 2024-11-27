package com.example.HotelManagement.Services;


import com.example.HotelManagement.Enums.UserRole;
import com.example.HotelManagement.Models.User;
import com.example.HotelManagement.Repository.UserRepository;
import com.example.HotelManagement.ResponceBodyAll.LoginBody;
import com.example.HotelManagement.ResponceBodyAll.ResponceBodyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppServices {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JWTService jwtService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponceBodyToken Register(User user){
         if (user.getUserRole()==null){
             user.setUserRole(UserRole.CUSTOMER);
         }

        User user1 =User.builder().email(user.getEmail()).firstName(user.getFirstName())
                .lastName(user.getLastName()).password(passwordEncoder.encode(user.getPassword())).
                userRole(user.getUserRole()).build();


         userRepository.save(user1);

        String jwt=jwtService.generateToken(user);

        return ResponceBodyToken.builder().token(jwt).build();

    }

    public ResponceBodyToken Login(LoginBody loginBody){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginBody.getEmail(),loginBody.getPassword()));
        User user=userRepository.findByEmail(loginBody.getEmail());
        String token=jwtService.generateToken(user);

        return ResponceBodyToken.builder().token(token).build();

    }
}
