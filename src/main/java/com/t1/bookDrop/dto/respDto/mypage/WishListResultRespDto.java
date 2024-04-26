package com.t1.bookDrop.dto.respDto.mypage;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WishListResultRespDto {
    private int totalWishCount;
    private List<WishListRespDto> wishList;
}
