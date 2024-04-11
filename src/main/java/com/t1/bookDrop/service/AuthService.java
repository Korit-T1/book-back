package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.AdminSigninReqDto;
import com.t1.bookDrop.dto.reqDto.SigninReqDto;
import com.t1.bookDrop.dto.reqDto.SignupReqDto;
import com.t1.bookDrop.entity.Admin;
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

        if(!passwordEncoder.matches(adminSigninReqDto.getPassword(), admin.getPassword())) {
            throw new BadCredentialsException("관리자 정보를 잘못 입력했습니다.\n다시 입력해주세요.");
        }

        return jwtProvider.generateAdminToken(admin);
    }
}
