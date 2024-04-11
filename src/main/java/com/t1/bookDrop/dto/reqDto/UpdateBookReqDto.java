package com.t1.bookDrop.dto.reqDto;


import com.t1.bookDrop.entity.Book;
import lombok.Data;

@Data
public class UpdateBookReqDto {
    private int bookId;
    private String isbn;
    private int categoryId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl;
    private int bookTypeId;

    public Book toEntity() {
        return Book.builder()
                .bookId(bookId)
                .isbn(isbn)
                .categoryId(categoryId)
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)

                .build();
    }
}