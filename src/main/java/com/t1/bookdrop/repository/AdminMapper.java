package com.t1.bookdrop.repository;

import com.t1.bookdrop.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public Admin adminCheckByUsername(String username);
}
