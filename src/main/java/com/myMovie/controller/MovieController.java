package com.myMovie.controller;

import com.myMovie.entity.Movie;
import com.myMovie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "电影相关API",tags = "电影模块")
@RequestMapping("/movie")
public class MovieController {

    @Resource
    private MovieService movieService;

    @PostMapping("/findAllMovies")
    @ResponseBody
    @ApiOperation(value="查找所有的电影",notes="用于渲染主页页面，包括正在上映的电影，即将上映的电影和热门电影")
    public Object findAllMovies(){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("data",movieService.getAllMovie(1));
        map.put("data1",movieService.getAllMovie(0));
        map.put("sort",movieService.getAllMovieByBoxOffice());
        return map;
    }

    @RequestMapping("/sortAllMovies")
    @ResponseBody
    public Object sortAllMovies(String movieType, String movieCountry, String movieYear, String order){
        List<Movie> movies = null;
        Map map = new HashMap();
        switch (order) {
            case "热门":
                movies = movieService.getMovies(movieType,movieCountry,movieYear,"movie_commentCount");
                break;
            case "时间":
                movies = movieService.getMovies(movieType,movieCountry,movieYear,"movie_releaseDate");
                break;
            case "评价":
                movies = movieService.getMovies(movieType,movieCountry,movieYear,"movie_score");
                break;
        }
        map.put("data",movies);
        map.put("count",movies.size());
        return map;
    }

    @RequestMapping("/findMovieById")
    @ResponseBody
    public Object findMovieById(@RequestParam("movie_id") int movieId){
        Map map = new HashMap();
        map.put("data",movieService.getMovieById(movieId));
        return map;
    }

}
