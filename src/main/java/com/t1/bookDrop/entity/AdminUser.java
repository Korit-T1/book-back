package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.AdminUserRespDto;
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
    private String gender;
    private String email;
    private String phone;
    private int age;
    private String address;
    private String birth;
    private int overdue;

    public AdminUserRespDto toAdminUserRespDto() {
        return AdminUserRespDto.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .gender(gender)
                .email(email)
                .phone(phone)
                .age(age)
                .address(address)
                .birth(birth)
                .overdue(overdue)
                .build();
    }
}
