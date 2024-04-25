package com.t1.bookDrop.dto.reqDto;

import com.t1.bookDrop.entity.Notice;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeReqDto {

    private int noticeBoardCategoryId;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Notice toEntity() {
        return Notice.builder()
                .noticeBoardCategoryId(noticeBoardCategoryId)
                .title(title)
                .content(content)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
