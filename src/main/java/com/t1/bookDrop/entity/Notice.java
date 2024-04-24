package com.t1.bookDrop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {

    private int noticeBoardId;
    private int noticeBoardCategoryId;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
