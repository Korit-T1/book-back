package com.t1.bookDrop.dto.reqDto;

import com.t1.bookDrop.entity.Loan;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanReqDto {
    private int loanId;
    private int userId;
    private int bookStockId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;


    public Loan toEntity() {
        return Loan.builder()
                .loanId(loanId)
                .userId(userId)
                .bookStockId(bookStockId)
                .loanDate(loanDate)
                .dueDate(dueDate)
                .returnDate(returnDate)
                .build();
    }
}
