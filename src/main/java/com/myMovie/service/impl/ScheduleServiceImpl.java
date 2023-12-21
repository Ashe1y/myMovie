package com.myMovie.service.impl;

import com.myMovie.entity.Cinema;
import com.myMovie.entity.Hall;
import com.myMovie.entity.Movie;
import com.myMovie.entity.Schedule;
import com.myMovie.mapper.*;
import com.myMovie.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;
    @Resource
    private HallMapper hallMapper;
    @Resource
    private MovieMapper movieMapper;
    @Resource
    private CinemaMapper cinemaMapper;
    @Resource
    private OrdInfoMapper oldInfoMapper;

    @Override
    public List<Schedule> getScheduleByCinemaIdAndMovieId(int cinemaId, int movieId) {
        System.out.println(movieId);
        List<Schedule> schedules = scheduleMapper.selectByCinemaIdAndMovieId(cinemaId, movieId);
        for (Schedule schedule : schedules) {
            //查找电影院 场次 电影
            Hall hall = hallMapper.selectHallByHallId((int) schedule.getHallId());
            Cinema cinema = cinemaMapper.selectCinemaByHallId((int)hall.getHallId());
            hall.setHallCinema(cinema);
            schedule.setScheduleHall(hall);
            Movie movie = movieMapper.selectMovieById((int)schedule.getMovieId());
            schedule.setScheduleMovie(movie);
            System.out.println(hall+","+cinema+","+movie);
        }
        return schedules;
    }

    @Override
    public Schedule getScheduleById(int scheduleId) {
        //获取某场电影
        Schedule schedule = scheduleMapper.selectScheduleById(scheduleId);
        //获取这场电影的作为信息
        schedule.setOrderList(oldInfoMapper.selectOldInfoByScheduleId(scheduleId));
        //获取这场电影的电影信息
        schedule.setScheduleMovie(movieMapper.selectMovieById((int)schedule.getMovieId()));
        //获取放映厅信息
        Hall hall = hallMapper.selectHallByHallId((int) schedule.getHallId());
        //获取电影院信息
        hall.setHallCinema(cinemaMapper.selectCinemaByHallId((int)hall.getHallId()));
        schedule.setScheduleHall(hall);

        return schedule;
    }
}
