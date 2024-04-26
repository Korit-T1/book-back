package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ReviewRespDto {
    private String content;
    private LocalDateTime createDate;
}
