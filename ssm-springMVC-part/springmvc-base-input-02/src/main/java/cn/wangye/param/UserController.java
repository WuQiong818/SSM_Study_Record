package cn.wangye.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping(value = {"/user/login"},method = {RequestMethod.GET,RequestMethod.POST})
    public String userLogin(@RequestParam("name") String username,
                            @RequestParam(value = "code") Integer password){
//
        System.out.println(username+password);
        return username+password;
    }


    @ResponseBody
    @RequestMapping("/param/mul")
    public Object mulForm(@RequestParam List<String> hbs){
        System.out.println(hbs);
        return hbs;
    }


}
