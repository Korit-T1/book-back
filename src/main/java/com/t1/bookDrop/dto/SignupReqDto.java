package com.t1.bookDrop.dto;


import com.t1.bookDrop.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Data
public class SignupReqDto {

    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private int age;
    private LocalDate birth;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .email(email)
                .phone(phone)
                .address(address)
                .gender(gender)
                .age(age)
                .birth(birth)
                .build();
    }

}
