package cn.wangye.controller;

import cn.wangye.pojo.Headline;
import cn.wangye.pojo.PortalVo;
import cn.wangye.pojo.Type;
import cn.wangye.service.HeadlineService;
import cn.wangye.service.TypeService;
import cn.wangye.utils.Result;
import org.apache.coyote.Request;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("portal")
public class PortalController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    @GetMapping("findAllTypes")
    public Result findAllTypes() {
//        return typeService.findAllTypes();
        List<Type> list = typeService.list();
        return Result.ok(list);


    }


    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo){
        return headlineService.findNewsPage(portalVo);
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(String hid){
        return headlineService.showHeadlineDetail(hid);
    }

}

