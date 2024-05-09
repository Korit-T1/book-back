package com.t1.bookDrop.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {
    public int findUser();
}
