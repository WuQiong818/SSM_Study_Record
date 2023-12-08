package cn.wangye.json;

import cn.wangye.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("json")
public class JsonController {
    @RequestMapping("data")
    public String data(@RequestBody Person person){
        System.out.println("person = " + person.toString());
        return person.toString();
    }
}
