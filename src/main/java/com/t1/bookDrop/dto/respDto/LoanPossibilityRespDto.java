package com.t1.bookDrop.dto.respDto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class LoanPossibilityRespDto {
    private int bookId;
    private int loanId;
    private int userId;
    private int bookStockId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private int loanStatus;
}
