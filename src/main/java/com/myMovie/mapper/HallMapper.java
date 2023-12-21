package com.myMovie.mapper;

import com.myMovie.entity.Hall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HallMapper {
    List<Hall> selectHallByMovieIdAndCinemaId(@Param("movieId") int movieId,@Param("cinemaId") int cinemaId);

    Hall selectHallByHallId(int hallId);
}
