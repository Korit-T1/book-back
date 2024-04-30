package com.t1.bookDrop.dto.reqDto;

import com.t1.bookDrop.entity.Review;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class ReviewReqDto {
    private int reviewId;
    private int bookId;
    private int userId;
    private String content;
    private float rating;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Review toEntity() {
        return Review.builder()
                .reviewId(reviewId)
                .bookId(bookId)
                .userId(userId)
                .content(content)
                .rating(rating)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
