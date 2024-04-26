package com.t1.bookDrop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeCategory {
    private int noticeBoardCategoryId;
    private String noticeBoardCategoryName;
}
