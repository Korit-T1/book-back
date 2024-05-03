package com.t1.bookDrop.dto.respDto.mypage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryRespDto {
    private int overdue;
    private int reading;
    private int returned;

    private String favoriteCategoryName;
    private int favoriteCategoryCount;
}
