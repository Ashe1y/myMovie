package com.myMovie.entity;

import java.util.List;

//放映厅
public class Hall {
    private long hallId;//放映厅Id

    private String hallName;//放映厅名称

    private int hallCapacity;//放映厅容量默认为12 * 12

    private long cinemaId;//影院Id

    private Cinema hallCinema;

    private List<Schedule> scheduleList;//这个影厅的 排片计划

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(int hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Cinema getHallCinema() {
        return hallCinema;
    }

    public void setHallCinema(Cinema hallCinema) {
        this.hallCinema = hallCinema;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public Hall() {
    }

    @Override
    public String toString() {
        return "Hall{" +
                "hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", hallCapacity=" + hallCapacity +
                ", cinemaId=" + cinemaId +
                ", hallCinema=" + hallCinema +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
