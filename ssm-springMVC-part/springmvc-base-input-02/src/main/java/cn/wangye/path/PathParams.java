package cn.wangye.path;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/path")
public class PathParams {

    /*
    * 如何接收路径参数
    * 1.设计动态路径，handler方法中使用{XXX}进行占位
    * 2.参数接收 在handler的参数列表中使用@PathVariable声明是路径参数;
    *
    * */
    @RequestMapping("info/{username}/{password}")
    public String cost(@PathVariable(value = "username") String account,  @PathVariable String password){
        System.out.println("username = " + account + ", password = " + password);
        return "ok";
    }

}
