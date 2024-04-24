package com.t1.bookDrop.dto.respDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
public class ReviewRespDto {
    private String content;
    private LocalDateTime createDate;
}
