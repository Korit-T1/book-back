package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    public List<Loan> getLoanHistory(String userName);
}
