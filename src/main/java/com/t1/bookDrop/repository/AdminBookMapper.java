package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.AdminBook;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminBookMapper {

    public int saveBook(AdminBook adminBook);
}
