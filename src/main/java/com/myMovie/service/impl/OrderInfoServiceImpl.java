package com.myMovie.service.impl;

import com.myMovie.entity.OrdInfo;
import com.myMovie.mapper.OrdInfoMapper;
import com.myMovie.mapper.ScheduleMapper;
import com.myMovie.service.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrdInfoMapper ordInfoMapper;
    @Resource
    private ScheduleMapper scheduleMapper;


    @Override
    @Transactional
    public int addOrderInfo(int scheduleId, String[] position, int price, int userId) {
        int result = 0;
        int cont = 0;
        int average = price/position.length;
        for (int i = 0; i < position.length; i++) {
            OrdInfo ordInfo = new OrdInfo();
            ordInfo.setOrderId(System.currentTimeMillis()+"");
            ordInfo.setScheduleId(scheduleId);
            ordInfo.setOrderPosition(position[i]);
            ordInfo.setOrderPrice(average);
            ordInfo.setOrderState(1);
            ordInfo.setOrderTime(new Date());
            int row  = ordInfoMapper.insertOrderInfo(ordInfo);
            if (row == 1) {
                cont++;
            } else {
                break;
            }
        }
        if (cont == position.length) {
            result = 1;
            scheduleMapper.updateScheduleRemain((cont*-1),scheduleId);
        }
        return result;
    }
}
