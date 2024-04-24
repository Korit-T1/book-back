package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.NoticeBoardReqDto;
import com.t1.bookDrop.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveNotice(NoticeBoardReqDto noticeBoardReqDto) {
        noticeMapper.saveNotice(noticeBoardReqDto.toEntity());
    }

}
