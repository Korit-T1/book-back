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

    private Book book;

    public WishListRespDto toRespDto() {
        return WishListRespDto.builder()
                .wishId(wishId)
                .bookId(bookId)
                .bookName(book.getBookName())
                .authorName(book.getAuthorName())
                .publisherName(book.getPublisherName())
                .imageUrl(book.getCoverImgUrl())
                .build();
    }

//    public WishListResultRespDto toRespDto(int count, List<WishListRespDto> list) {
//        return WishListResultRespDto.builder()
//                .totalWishCount(count)
//                .wishListRespDto(list)
//                .build();
//    }

}
