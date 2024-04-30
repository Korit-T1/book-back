package com.t1.bookDrop.dto.reqDto;

import com.t1.bookDrop.entity.Notice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateNoticeReqDto {

    private int noticeBoardCategoryId;
    private String title;
    private String content;

    public Notice toEntity(int noticeBoardId) {
        return Notice.builder()
                .noticeBoardId(noticeBoardId)
                .noticeBoardCategoryId(noticeBoardCategoryId)
                .title(title)
                .content(content)
                .build();
    }
}
