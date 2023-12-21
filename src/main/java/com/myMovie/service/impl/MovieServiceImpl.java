package com.myMovie.service.impl;

import com.myMovie.entity.*;
import com.myMovie.mapper.*;
import com.myMovie.service.MovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Resource
    private MovieMapper movieMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CinemaMapper cinemaMapper;
    @Resource
    private HallMapper hallMapper;
    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Movie> getAllMovie(int movieState) {
        return movieMapper.selectAllByMovieState(movieState);
    }

    @Override
    public List<Movie> getAllMovieByBoxOffice() {
        return movieMapper.selectAllMoviesByBoxOffice();
    }

    @Override
    public List<Movie> getMovies(String movieType, String movieCountry, String movieYear, String orderType) {
        return movieMapper.selectMovies(movieType,movieCountry,movieYear,orderType);
    }

    @Override
    public Movie getMovieById(int movieId) {
        Movie movie = movieMapper.selectMovieById(movieId);
        //评论
        List<Comment> comments = commentMapper.selectCommentByMovieId(movieId);
        for (Comment comment : comments) {
            User user = userMapper.selectUserById(comment.getUserId());
            comment.setCommentUser(user);
        }
        movie.setCommentList(comments);
        //放映厅与影院
        List<Cinema> cinemas = cinemaMapper.selectCinemaByMovieId(movieId);
        for (Cinema cinema : cinemas) {
            List<Hall> halls = hallMapper.selectHallByMovieIdAndCinemaId(movieId,(int)cinema.getCinemaId());
            for (Hall hall : halls) {
                List<Schedule> schedules = scheduleMapper.selectScheduleByMovieIdAndHallId(movieId, (int) hall.getHallId());
                hall.setScheduleList(schedules);
            }
            cinema.setHallList(halls);
        }
        movie.setCinemaList(cinemas);
        return movie;
    }
}
