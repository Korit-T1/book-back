package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class GetWishReqDto {
    private int userid;
    private int page;
    private int option;
}
