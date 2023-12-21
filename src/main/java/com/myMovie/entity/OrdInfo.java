package com.myMovie.entity;

import java.util.Date;

//购票
public class OrdInfo {
    private String orderId;//订单Id

    private long userId;//所属⽤户Id

    private long scheduleId;//所属场次Id

    private String orderPosition;//电影票座位（x排x座）

    private int orderState;//订单状态 0:退票中 1:已⽀付 2:退票成功

    private int orderPrice;//订单价格

    private Date orderTime;//订单⽀付时间

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(String orderPosition) {
        this.orderPosition = orderPosition;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public OrdInfo() {
    }

    @Override
    public String toString() {
        return "OrdInfo{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", scheduleId=" + scheduleId +
                ", orderPosition='" + orderPosition + '\'' +
                ", orderState=" + orderState +
                ", orderPrice=" + orderPrice +
                ", orderTime=" + orderTime +
                '}';
    }
}
