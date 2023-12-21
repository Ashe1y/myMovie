package com.myMovie.entity;

import java.util.List;

//场次
public class Schedule {

    private long scheduleId;//场次Id

    private long hallId;//放映厅Id

    private long movieId;//电影Id

    private String scheduleStartTime;//电影放映时间

    private int schedulePrice;//场次价格

    private int scheduleRemain;//剩余座位数 默认12 * 12

    private int scheduleState;//场次状态默认1; 1：上映中   0：下架

    private Hall scheduleHall;//对应场次

    private Movie scheduleMovie;//对应电影

    private Cinema scheduleCinema;//对应影院

    private List<OrdInfo> orderList;//订单详细

    public List<OrdInfo> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrdInfo> orderList) {
        this.orderList = orderList;
    }

    public Cinema getScheduleCinema() {
        return scheduleCinema;
    }

    public void setScheduleCinema(Cinema scheduleCinema) {
        this.scheduleCinema = scheduleCinema;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getScheduleStartTime() {
        return scheduleStartTime;
    }

    public void setScheduleStartTime(String scheduleStartTime) {
        this.scheduleStartTime = scheduleStartTime;
    }

    public int getSchedulePrice() {
        return schedulePrice;
    }

    public void setSchedulePrice(int schedulePrice) {
        this.schedulePrice = schedulePrice;
    }

    public int getScheduleRemain() {
        return scheduleRemain;
    }

    public void setScheduleRemain(int scheduleRemain) {
        this.scheduleRemain = scheduleRemain;
    }

    public int getScheduleState() {
        return scheduleState;
    }

    public void setScheduleState(int scheduleState) {
        this.scheduleState = scheduleState;
    }

    public Hall getScheduleHall() {
        return scheduleHall;
    }

    public void setScheduleHall(Hall scheduleHall) {
        this.scheduleHall = scheduleHall;
    }

    public Movie getScheduleMovie() {
        return scheduleMovie;
    }

    public void setScheduleMovie(Movie scheduleMovie) {
        this.scheduleMovie = scheduleMovie;
    }

    public Schedule() {
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", hallId=" + hallId +
                ", movieId=" + movieId +
                ", scheduleStartTime='" + scheduleStartTime + '\'' +
                ", schedulePrice=" + schedulePrice +
                ", scheduleRemain=" + scheduleRemain +
                ", scheduleState=" + scheduleState +
                ", scheduleHall=" + scheduleHall +
                ", scheduleMovie=" + scheduleMovie +
                '}';
    }
}
