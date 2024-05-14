package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    public int saveReview(Review review);

    public List<Review> findReviewsAllByBookId(
            @Param("index") int index,
            @Param("book_id") int id);

    public int findReviewCount(int id);
}
