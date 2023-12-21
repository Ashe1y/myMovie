package com.myMovie.service;

import com.myMovie.entity.Movie;

import java.util.List;

public interface MovieService {
    /**
     * 查询上映的电影
     * @param movieState 电影状态
     * @return
     * 上映的电影
     */
    List<Movie> getAllMovie(int movieState);

    /**
     * 查询以票房倒叙排列的电影
     * @return
     * 房倒叙排列的电影
     */
    List<Movie> getAllMovieByBoxOffice();

    /**
     * 以各种条件查询电影
     * @param movieType
     * @param movieCountry
     * @param movieYear
     * @param orderType
     * @return
     * 电影集合
     */
    List<Movie> getMovies(String movieType,String movieCountry,String movieYear,String orderType);

    /**
     *
     * 根据电影的id查询电影
     * @return
     */
    Movie getMovieById(int movieId);
}
