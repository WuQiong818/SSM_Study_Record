package cn.wangye;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
//    handler --> springmvc/hello return "hello springMVC!!"

    /*如果我们的方法对应一个路径，可以直接将value省略，以字符串的格式书写
    如果对应这多个参数的话，我们需要写values和{}，多个路径以字符串格式写到数组当中*/
//    @RequestMapping(value = {"/springmvc"},method = RequestMethod.GET)  //前面没有/,直接路径开头
    @GetMapping(value = {"/springmvc"})//便捷写法，一个萝卜一个坑是常见的
    @ResponseBody //这里是直接返回字符串给前端，不再去寻找视图解析器
    public String helloSpringMVC(){
        System.out.println("hello SpringMVC");
//        返回前端
        return  "POST--Hello-SpringMVC!!";
    }


    @RequestMapping(value = "/world",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String helloWorld(){
        System.out.println("hello world");
        return "POST&&GET-Hello - World";
    }


}

