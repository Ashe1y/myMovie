package com.myMovie.service;

import com.myMovie.entity.OrdInfo;

public interface OrderInfoService {
    /**
     *  购买后加入订单
     * @param scheduleId 场次ID
     * @param position 位置
     * @param price 总价
     * @param userId 用户ID
     * @return
     *  0 失败
     *  1 成功
     */
    int addOrderInfo(int scheduleId,String[] position,int price,int userId);
}
