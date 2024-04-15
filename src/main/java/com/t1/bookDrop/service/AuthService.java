package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.*;
import com.t1.bookDrop.entity.Admin;
import com.t1.bookDrop.entity.OAuth2;
import com.t1.bookDrop.entity.User;
import com.t1.bookDrop.exception.SaveException;
import com.t1.bookDrop.jwt.JwtProvider;
import com.t1.bookDrop.repository.AdminMapper;
import com.t1.bookDrop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public boolean isCheckedByUsername(String username) {
        return userMapper.userCheckByUsername(username) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    public void signup(SignupReqDto signupReqDto) {
        int successCount = 0;

        User user = signupReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);

        if(successCount < 1) {
            throw new SaveException();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void oAuth2Signup(OAuth2SignupReqDto oAuth2SignupReqDto) {
        int successCount = 0;

        User user = oAuth2SignupReqDto.toEntity(passwordEncoder);

        successCount += userMapper.saveUser(user);
        successCount += userMapper.saveOAuth2(oAuth2SignupReqDto.toOAuth2Entity(user.getUserId()));

        if(successCount < 2) {
            throw new SaveException();
        }
    }

    public String signin(SigninReqDto signinReqDto) {
        User user = userMapper.userCheckByUsername(signinReqDto.getUsername());

        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 잘못 입력했습니다.\n다시 입력해주세요.");
        }

        if(!passwordEncoder.matches(signinReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 잘못 입력했습니다.\n다시 입력해주세요.");
        }

        return jwtProvider.generateToken(user);
    }

    public String adminSignin(AdminSigninReqDto adminSigninReqDto) {
        Admin admin = adminMapper.adminCheckByUsername(adminSigninReqDto.getUsername());

        if(admin == null) {
            throw new UsernameNotFoundException("관리자 정보를 잘못 입력했습니다.\n다시 입력해주세요.");
        }
        // DB에 저장된 비밀번호를 디코딩하여 평문으로 변환
        byte[] decodedPassword = Base64.getDecoder().decode(admin.getPassword());
        String decodedPasswordString = new String(decodedPassword);

        // 입력된 비밀번호와 디코딩된 비밀번호를 비교
        if(!adminSigninReqDto.getPassword().equals(decodedPasswordString)) {
            throw new BadCredentialsException("관리자 정보를 잘못 입력했습니다.\n다시 입력해주세요.");
        }
        return jwtProvider.generateAdminToken(admin);
    }

    public void oAuth2Merge(OAuth2MergeReqDto oAuth2MergeReqDto) {
        User user = userMapper.userCheckByUsername(oAuth2MergeReqDto.getUsername());

        if(user == null) {
            throw new UsernameNotFoundException("사용자 정보를 확인할 수 없습니다.");
        }

        if(!passwordEncoder.matches(oAuth2MergeReqDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 확인할 수 없습니다.");
        }

        OAuth2 oAuth2 = OAuth2.builder()
                .oAuth2Name(oAuth2MergeReqDto.getOauth2Name())
                .userId(user.getUserId())
                .providerName(oAuth2MergeReqDto.getProviderName())
                .build();

        userMapper.saveOAuth2(oAuth2);
    }
}
