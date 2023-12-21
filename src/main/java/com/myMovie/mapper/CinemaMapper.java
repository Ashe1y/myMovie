package com.myMovie.mapper;

import com.myMovie.entity.Cinema;

import java.util.List;

public interface CinemaMapper {
    List<Cinema> selectCinemaByMovieId(int movieId);

    Cinema selectCinemaByHallId(int hallId);
}
