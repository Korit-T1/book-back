package com.t1.bookDrop.service;

import com.t1.bookDrop.dto.reqDto.NoticeReqDto;
import com.t1.bookDrop.dto.respDto.NoticeRespDto;
import com.t1.bookDrop.entity.Notice;
import com.t1.bookDrop.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveNotice(NoticeReqDto noticeBoardReqDto) {
        noticeMapper.saveNotice(noticeBoardReqDto.toEntity());
    }

    public List<NoticeRespDto> getNotice(int noticeBoardId){
        return noticeMapper.findNoticeAllByNoticeBoardId(noticeBoardId).stream().map(Notice::toDto).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteNotice(List<Integer> noticeIds) {
        noticeMapper.deleteNoticeByNoticeIds(noticeIds);
    }

}
