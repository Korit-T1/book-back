package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.AdminUserReqDto;
import com.t1.bookDrop.dto.respDto.AdminUserRespDto;
import com.t1.bookDrop.entity.AdminUser;
import com.t1.bookDrop.entity.User;
import com.t1.bookDrop.exception.ValidException;
import com.t1.bookDrop.repository.AdminUserMapper;
import com.t1.bookDrop.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Autowired
    UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public List<AdminUserRespDto> getUsers(AdminUserReqDto adminUserReqDto) {

        List<AdminUser> users = adminUserMapper.findUser(
                adminUserReqDto.getUsername(),
                adminUserReqDto.getName(),
                adminUserReqDto.getEmail(),
                adminUserReqDto.getPhone()
        );
        System.out.println(users);
        return users.stream().map(AdminUser::toAdminUserRespDto).collect(Collectors.toList());
    }

    public AdminUserRespDto findUser(AdminUserReqDto adminUserReqDto) {
        User user = userMapper.findUser(
                adminUserReqDto.getUsername(),
                adminUserReqDto.getName(),
                adminUserReqDto.getEmail(),
                adminUserReqDto.getPhone()
        );

        return AdminUserRespDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
