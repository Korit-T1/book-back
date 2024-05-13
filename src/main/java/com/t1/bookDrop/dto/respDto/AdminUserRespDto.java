package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdminUserRespDto {
    private int userId;
    private String username;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String birth;
    private int overdue;
}
