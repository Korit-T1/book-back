package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.mypage.WishListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Wish {
    private int wishId;
    private int bookId;
    private int userId;

    private Book book;

    public WishListRespDto toRespDto() {
        return WishListRespDto.builder()
                .wishId(wishId)
                .bookId(bookId)
                .bookName(book.getBookName())
                .authorName(book.getBookName())
                .publisherName(book.getPublisherName())
                .imageUrl(book.getCoverImgUrl())
                .build();
    }
}
