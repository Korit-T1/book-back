package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.mypage.WishListRespDto;
import com.t1.bookDrop.dto.respDto.mypage.WishListResultRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wish {
    private int wishId;
    private int bookId;
    private int userId;

    private int reviewCount;
    private float avgRating;

    private Book book;

    public WishListRespDto toRespDto() {
        return WishListRespDto.builder()
                .wishId(wishId)
                .bookId(bookId)
                .avgRating(avgRating)
                .reviewCount(reviewCount)
                .bookName(book.getBookName())
                .authorName(book.getAuthorName())
                .publisherName(book.getPublisherName())
                .imageUrl(book.getCoverImgUrl())
                .build();
    }

}
