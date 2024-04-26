package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.mypage.LoanHistoryRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {
    private int loanId;
    private int bookStockId;
    private int userId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    private Book book;

    public LoanHistoryRespDto toRespDto() {
        return LoanHistoryRespDto.builder()
                .loanId(loanId)
                .bookStockId(bookStockId)
                .authorName(book.getAuthorName())
                .bookName(book.getBookName())
                .publisherName(book.getPublisherName())
                .imageUrl(book.getCoverImgUrl())
                .build();
    }
}
