package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    public int saveNotice(Notice notice);
}
