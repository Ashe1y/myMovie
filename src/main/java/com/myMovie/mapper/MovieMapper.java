package com.myMovie.mapper;

import com.myMovie.entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.List;

public interface MovieMapper {
    List<Movie> selectAllByMovieState(int movieState);

    List<Movie> selectAllMoviesByBoxOffice();

    List<Movie> selectMovies(@Param("movieType") String movieType,
                             @Param("movieCountry") String movieCountry,
                             @Param("movieYear") String movieYear,
                             @Param("orderType") String orderType);

    Movie selectMovieById(int movieId);

    int updateCommentCount(@Param("movieId") int movieId,@Param("row") int row);

    Movie selectMoveByCommentId(int commentId);
}
