package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.SearchBookRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate publishDate;

    private Category category;
    private float averageRating;
    private int reviewCount;

    public SearchBookRespDto toSearchBookRespDto() {
        return SearchBookRespDto.builder()
                .bookId(bookId)
                .isbn(isbn)
                .categoryId(categoryId)
                .categoryName(category.getCategoryName())
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)
                .publishDate(publishDate)
                .averageRating(averageRating)
                .reviewCount(reviewCount)
                .build();
    }


}
