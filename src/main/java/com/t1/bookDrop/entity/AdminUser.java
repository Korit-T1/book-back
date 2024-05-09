package com.t1.bookDrop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminUser {
    private int userId;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String birth;
}
