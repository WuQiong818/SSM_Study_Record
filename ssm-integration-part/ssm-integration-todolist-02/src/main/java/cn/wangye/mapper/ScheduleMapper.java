package cn.wangye.mapper;

import cn.wangye.pojo.Schedule;
import cn.wangye.utils.R;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> queryList();

    int deleteById(int id);

    int saveSchedule(Schedule schedule);

    int updateSchedule(Schedule schedule);
}
