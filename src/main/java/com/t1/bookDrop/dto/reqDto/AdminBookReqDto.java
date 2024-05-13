package com.t1.bookDrop.dto.reqDto;

import com.t1.bookDrop.entity.AdminBook;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminBookReqDto {
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

    public AdminBook toEntity() {
        return AdminBook.builder()
                .bookId(bookId)
                .isbn(isbn)
                .categoryId(categoryId)
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)
                .createDate(createDate)
                .updateDate(updateDate)
                .publishDate(publishDate)
                .build();
    }
}
