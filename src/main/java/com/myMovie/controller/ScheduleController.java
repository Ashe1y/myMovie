package com.myMovie.controller;

import com.myMovie.entity.Schedule;
import com.myMovie.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    @RequestMapping("findScheduleByCinemaAndMovie")
    @ResponseBody
    public Object findScheduleByCinemaAndMovie(@RequestParam("movie_id") int movieId,@RequestParam("cinema_id") int cinemaId){
        Map map = new HashMap();
        List<Schedule> schedules = scheduleService.getScheduleByCinemaIdAndMovieId(cinemaId,movieId);
        map.put("data",schedules);
        return map;
    }

    @RequestMapping("/findScheduleById")
    @ResponseBody
    public Object findScheduleById(@RequestParam("schedule_id") int scheduleId){
        Map map = new HashMap();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        map.put("data",schedule);
        return map;
    }

}
