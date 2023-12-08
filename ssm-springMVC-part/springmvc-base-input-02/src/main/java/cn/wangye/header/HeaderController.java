package cn.wangye.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("header")
public class HeaderController {

    @RequestMapping("data")
//   对于header请求头的接受，接受的参数名首字母大小写都可以，没有问题;
    public String getHeader(@RequestHeader("cookie") String Host){
        System.out.println("host"+Host);
        return Host+"=host";
    }



}
