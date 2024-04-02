package com.t1.bookdrop.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class SignupReqDto {

    @Pattern(regexp = "^[A-Za-z0-9]{4,10}$", message = "영문자, 숫자 조합 5~10자리 이어야 합니다.")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,128}$", message = "영문자와 숫자, 특수문자 조합으로 8~128자리 이어야 합니다.")
    private String password;
    @Pattern(regexp = "^[가-힣]{1,}$", message = "최소 두 글자의 한글로 표시해주세요.")
    private String name;
    @Email(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{1,3}$", message = "이메일 형식이어야 합니다.")
    private String email;

}
