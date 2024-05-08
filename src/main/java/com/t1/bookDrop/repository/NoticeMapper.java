package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public int saveNotice(Notice notice);

    Notice findNoticeByNoticeBoardId(int noticeBoardId);

    public List<Notice> findNoticeAll(
            @Param("index") int index,
            @Param("count") int count,
            @Param("option") int option,
            @Param("text") String text);

    public int getBookCount(
            @Param("option") int option,
            @Param("text") String text);

    public int deleteNoticeByNoticeIds(List<Integer> noticeIds);

    public int updateNoticeByNoticeId(Notice notice);
}
