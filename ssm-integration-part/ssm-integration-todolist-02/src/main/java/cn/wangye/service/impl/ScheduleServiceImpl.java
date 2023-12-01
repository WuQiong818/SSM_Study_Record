package cn.wangye.service.impl;

import cn.wangye.mapper.ScheduleMapper;
import cn.wangye.pojo.Schedule;
import cn.wangye.service.ScheduleService;
import cn.wangye.utils.PageBean;
import cn.wangye.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public R page(int pageSize, int currentPage) {
//        分页
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> scheduleList = scheduleMapper.queryList();
        PageInfo<Schedule> info = new PageInfo<>(scheduleList);
        PageBean<Schedule> pageBean = new PageBean<>(currentPage, pageSize, info.getTotal(), info.getList());
        R ok = R.ok(pageBean);
        return ok;
    }

    @Override
    public R deleteById(int id) {
        int num = scheduleMapper.deleteById(id);
        R r = new R();
        if (num == 0) r = R.fail(null);
        return r;
    }

    @Override
    public R saveSchedule(Schedule schedule) {
        int count = scheduleMapper.saveSchedule(schedule);
        R r = new R();
        if (count == 0) r = R.fail(null);
        return r;
    }

    @Override
    public R updateSchedule(Schedule schedule) {
        int count = scheduleMapper.updateSchedule(schedule);
        R r = new R();
        if (count == 0) r = R.fail(null);
        return r;
    }
}
