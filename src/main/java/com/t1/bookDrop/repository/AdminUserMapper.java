package com.t1.bookDrop.repository;

import com.t1.bookDrop.dto.reqDto.AdminUserReqDto;
import com.t1.bookDrop.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserMapper {
    public List<AdminUser> findUser(
            @Param("username") String username,
            @Param("name") String name
    );
}
