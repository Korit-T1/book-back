package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class EditPasswordReqDto {

    private String userId;
    private String username;
    private String name;
    private String phone;
    private String email;

    private String oldPassword;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,128}$",
            message = "영문, 특문, 숫자를 포함한 8 ~ 128자리 형식이어야 합니다.")
    private String newPassword;

    @NotBlank
    private String newPasswordCheck;
}
