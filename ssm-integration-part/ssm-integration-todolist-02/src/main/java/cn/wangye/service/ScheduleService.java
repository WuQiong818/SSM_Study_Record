package cn.wangye.service;

import cn.wangye.pojo.Schedule;
import cn.wangye.utils.R;
import org.springframework.stereotype.Service;

public interface ScheduleService {
    R page(int pageSize, int currentPage);

    R deleteById(int id);

    R saveSchedule(Schedule schedule);

    R updateSchedule(Schedule schedule);
}
