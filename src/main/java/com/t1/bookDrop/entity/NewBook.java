package com.t1.bookDrop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
class NewBook {
    private int newBookId;
    private int bookId;
    private LocalDateTime publishDate;


}