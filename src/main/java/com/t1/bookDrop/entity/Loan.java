package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.LoanPossibilityRespDto;
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
public class Loan {
    private int loanId;
    private int bookStockId;
    private int userId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    private int loanStatus;
    private BookStock bookStock;
    private List<BookStock> bookStocks;

    public LoanPossibilityRespDto toLoanPossibilityRespDto() {
        return LoanPossibilityRespDto.builder()
                .bookId(bookStock.getBookId())
                .loanId(loanId)
                .bookStockId(bookStockId)
                .userId(userId)
                .loanDate(loanDate)
                .dueDate(dueDate)
                .returnDate(returnDate)
                .loanStatus(loanStatus)
                .build();
    }

    public LoanHistoryRespDto toLoanHistoryRespDto() {
        return LoanHistoryRespDto.builder()
                .loanId(loanId)
                .bookStockId(bookStockId)
                .bookName(bookStock.getBook().getBookName())
                .authorName(bookStock.getBook().getAuthorName())
                .publisherName(bookStock.getBook().getPublisherName())
                .loanDate(loanDate)
                .dueDate(dueDate)
                .returnDate(returnDate)
                .build();
    }
}
