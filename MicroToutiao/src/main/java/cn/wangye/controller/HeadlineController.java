package cn.wangye.controller;

import cn.wangye.pojo.Headline;
import cn.wangye.service.HeadlineService;
import cn.wangye.utils.JwtHelper;
import cn.wangye.utils.Result;
import cn.wangye.utils.ResultCodeEnum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("publish")
    public Result publish(@RequestHeader String token, @RequestBody Headline headline) {
        int userId = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(userId);
        return headlineService.publish(headline);
    }

    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(String hid){
        Headline headline = headlineService.getById(hid);
        if (headline != null){
            Map<String,Object> headlineMap = new HashMap();
            headlineMap.put("headline",headline);
            return Result.ok(headlineMap);
        }
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }
    @PostMapping("update")
    public Result update(@RequestBody Headline headline){
        return headlineService.updateHeadline(headline);
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid){
        return headlineService.removeByHid(hid);
    }



}
