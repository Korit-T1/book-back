package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    public int saveNotice(Notice notice);

    Notice findNoticeByNoticeBoardId(int noticeBoardId);

    public int deleteNoticeByNoticeIds(List<Integer> noticeIds);

    public int updateNoticeByNoticeId(Notice notice);
}
