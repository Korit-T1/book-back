package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class NoticeRespDto {

    private int noticeBoardId;
    private int noticeBoardCategoryId;
    private String noticeBoardCategoryName;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
