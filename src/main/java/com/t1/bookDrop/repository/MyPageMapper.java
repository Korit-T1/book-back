package com.t1.bookDrop.repository;

import com.t1.bookDrop.entity.FavoriteCategory;
import com.t1.bookDrop.entity.Loan;
import com.t1.bookDrop.entity.MostLoanedBook;
import com.t1.bookDrop.entity.Wish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {
    public List<Loan> getReadingBooks(
            @Param("index") int index,
            @Param("userid") int userid,
            @Param("option") int option
    );

    public int getReadingBooksCount(
            @Param("userid") int userid,
            @Param("option") int option
    );

    public List<Loan> getReturnedBooks(
            @Param("index") int index,
            @Param("userid") int userid,
            @Param("filter") int filter
    );
    public int getReturnedBooksCount(
            @Param("userid") int userid,
            @Param("filter") int filter
    );

    public List<Wish> getWishList(
            @Param("index") int index,
            @Param("userid") int userid,
            @Param("filter") int filter
    );
    public int getWishCount(
            @Param("userid") int userid,
            @Param("filter") int filter
    );

    public int updateProfileImage(@Param("userid") int userid, @Param("url") String url);

    public int getOverdueCount(int userid);
    public int getReadingCount(int userid);
    public int getReturnedCount(int userid);

    public FavoriteCategory getFavoriteInfo(int userid);
    public MostLoanedBook getMostLoanedInfo(int userid);
}
