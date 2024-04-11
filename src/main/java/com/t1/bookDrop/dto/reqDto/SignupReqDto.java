package com.t1.bookDrop.dto.reqDto;


import com.t1.bookDrop.entity.User;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class SignupReqDto {

    @Pattern(regexp = "^[A-Za-z0-9]{4,10}$", message = "영문자, 숫자 조합 5~10자리 이어야 합니다.")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,128}$", message = "영문자와 숫자, 특수문자 조합으로 최소 8자리 이어야 합니다.")
    private String password;
    @Pattern(regexp = "^[가-힣]{1,}$", message = "최소 두 글자 이상의 한글로 입력해주세요.")
    private String name;
    @Email(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{1,3}$", message = "이메일 형식이어야 합니다.")
    private String email;
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "올바른 휴대전화 번호 형식을 입력해주세요. 예: 010-1234-1234")
    private String phone;
    @NonNull
    private String address;
    @NonNull
    private String gender;
    @Min(value = 1, message = "최소 한 자리 이상의 숫자를 입력해주세요.")
    private int age;
    @Pattern(regexp = "^(19|20)\\d{2}\\-((11|12)|(0?(\\d)))\\-(30|31|((0|1|2)?\\d))$", message = "올바른 생년월일 형식을 입력해주세요. 예: 2000-01-01")
    private String birth;

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
