package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.SearchBookRespDto;

import com.t1.bookDrop.dto.respDto.mypage.LoanHistoryRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private int bookId;
    private String isbn;
    private int categoryId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime publishDate;

    private Category category;
    private Rating rating;
    private BookStock bookStock;


    public SearchBookRespDto toSearchBookRespDto() {
        return SearchBookRespDto.builder()
                .bookId(bookId)
                .isbn(isbn)
                .categoryId(categoryId)
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)
                .publishDate(publishDate)
                .categoryName(category.getCategoryName())
                .build();
    }


}
