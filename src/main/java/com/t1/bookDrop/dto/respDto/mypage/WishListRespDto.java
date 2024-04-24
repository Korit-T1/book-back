package com.t1.bookDrop.dto.respDto.mypage;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WishListRespDto {
    private int wishId;
    private int bookId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String imageUrl;
}
