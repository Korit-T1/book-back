package com.t1.bookdrop.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Loan {
    private int loanId;
    private int userId;
    private int bookStockId;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
}
