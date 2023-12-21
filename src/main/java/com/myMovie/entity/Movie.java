package com.myMovie.entity;

import java.util.List;

public class Movie {

    private long movieId; //电影编号

    private String movieCnName;//电影中文名称

    private String movieFgName;//电影外语名称

    private String movieActor;//电影演职人员

    private String movieDirector;//电影导演

    private String movieDetail;//电影详情

    private String movieDuration;//电影时长

    private String movieType;//电影类型

    private float movieScore;//电影评分

    private float movieBoxOffice;//电影票房

    private String movieCommentCount;   // 电影参评人数

    private String movieReleaseDate;//电影上映时间

    private String movieCountry;//电影制片地区

    private String moviePicture;//电影海报

    private int movieState;//电影状态 默认为1  1：上映 0：即将上映 2：下架

    private List<Comment> commentList;//电影评论

    private List<Cinema> cinemaList;//放映该电影的影院

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieCnName() {
        return movieCnName;
    }

    public void setMovieCnName(String movieCnName) {
        this.movieCnName = movieCnName;
    }

    public String getMovieFgName() {
        return movieFgName;
    }

    public void setMovieFgName(String movieFgName) {
        this.movieFgName = movieFgName;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(String movieDetail) {
        this.movieDetail = movieDetail;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public float getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(float movieScore) {
        this.movieScore = movieScore;
    }

    public float getMovieBoxOffice() {
        return movieBoxOffice;
    }

    public void setMovieBoxOffice(float movieBoxOffice) {
        this.movieBoxOffice = movieBoxOffice;
    }

    public String getMovieCommentCount() {
        return movieCommentCount;
    }

    public void setMovieCommentCount(String movieCommentCount) {
        this.movieCommentCount = movieCommentCount;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public void setMoviePicture(String moviePicture) {
        this.moviePicture = moviePicture;
    }

    public int getMovieState() {
        return movieState;
    }

    public void setMovieState(int movieState) {
        this.movieState = movieState;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieCnName='" + movieCnName + '\'' +
                ", movieFgName='" + movieFgName + '\'' +
                ", movieActor='" + movieActor + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieDetail='" + movieDetail + '\'' +
                ", movieDuration='" + movieDuration + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieScore=" + movieScore +
                ", movieBoxOffice=" + movieBoxOffice +
                ", movieCommentCount='" + movieCommentCount + '\'' +
                ", movieReleaseDate='" + movieReleaseDate + '\'' +
                ", movieCountry='" + movieCountry + '\'' +
                ", moviePicture='" + moviePicture + '\'' +
                ", movieState=" + movieState +
                ", commentList=" + commentList +
                ", cinemaList=" + cinemaList +
                '}';
    }
}
