package cn.wangye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("test")
@ResponseBody
public class TestController {
    @GetMapping("data1")
    public String data1() {
        return "OK";
    }
}
