package com.myMovie.service;

import com.myMovie.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleByCinemaIdAndMovieId(int cinemaId,int movieId);

    /**
     * 查找可订票信息
     * @param scheduleId 场次ID
     * @return
     * 场次
     * List订单
     * 电影
     * 放映厅
     * 影院
     */
    Schedule getScheduleById(int scheduleId);
}
