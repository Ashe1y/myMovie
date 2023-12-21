package com.myMovie.mapper;

import com.myMovie.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> selectScheduleByMovieIdAndHallId(@Param("movieId") int movieId,@Param("hallId") int hallId);

    List<Schedule> selectByCinemaIdAndMovieId(@Param("cinemaId") int cinemaId,@Param("movieId") int movieId);

    Schedule selectScheduleById(int scheduleId);

    int updateScheduleRemain(@Param("row") int row,@Param("scheduleId") int scheduleId);
}
