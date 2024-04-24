package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.ReviewRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private int reviewId;
    private int bookId;
    private int userId;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ReviewRespDto toDto() {
        return ReviewRespDto.builder()
                .content(content)
                .createDate(createDate)
                .build();
    }
}
