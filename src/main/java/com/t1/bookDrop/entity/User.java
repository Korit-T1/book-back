package com.t1.bookDrop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private int age;
    private LocalDate birth;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
