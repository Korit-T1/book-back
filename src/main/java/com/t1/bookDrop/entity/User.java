package com.t1.bookDrop.entity;

import com.t1.bookDrop.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String birth;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private List<OAuth2> oAuth2s;

    public PrincipalUser toPrincipalUser() {
        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .email(email)
                .address(address)
                .phone(phone)
                .build();
    }
}
