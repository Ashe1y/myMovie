package com.myMovie.mapper;

import com.myMovie.entity.OrdInfo;

import java.util.List;

public interface OrdInfoMapper {
    List<OrdInfo> selectOldInfoByScheduleId(int scheduleId);

    int insertOrderInfo(OrdInfo oldInfo);
}
