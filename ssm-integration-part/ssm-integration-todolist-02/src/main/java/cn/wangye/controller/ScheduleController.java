package cn.wangye.controller;

import cn.wangye.pojo.Schedule;
import cn.wangye.service.ScheduleService;
import cn.wangye.utils.R;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin//解决跨域请求问题
@RestController
@RequestMapping("schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize,
                  @PathVariable int currentPage){
        R r = scheduleService.page(pageSize,currentPage);
//        当我们添加slf4j之后会有一个日志输出的格式文本 log
        log.info("查询到的结果是:{}",r);
        return r;
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable int id){
        R r = scheduleService.deleteById(id);
        log.info("删除成功{}",r);
        return r;
    }

    @PostMapping()
    public R save(@Validated @RequestBody Schedule schedule,BindingResult result){
        if (result.hasErrors()){
            return R.fail("关键参数错误");
        }
        R r = scheduleService.saveSchedule(schedule);
        return r;
    }

    @PutMapping()
    public R update(@Validated @RequestBody Schedule schedule,BindingResult result){
        if (result.hasErrors()) return R.fail("关键参数错误");
        R r = scheduleService.updateSchedule(schedule);
        return r;
    }



}
