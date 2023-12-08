package cn.wangye.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("save")
public class JSPController {

    /**
     * TODO:快速查找视图
     * 1.方法的返回值的字符串类型
     * 2.不能添加@ResponseBody（自己返回字符串给前端，不走视图解析器，不加载视图）
     * 3.返回值 对应中间的视图名称即可
     */
    @RequestMapping(value = "jump", method = RequestMethod.GET)
    public String jumpJsp(HttpServletRequest model) {
        System.out.println("FileController.jumpJsp");
        model.setAttribute("msg", "request data!!!");
        return "home";
    }

    @RequestMapping("forward")
    public String forward() {
        System.out.println("forward-jsp");
        return "forward:/save/jump";
    }

    @RequestMapping("redirect")
    public String redirect(){
        System.out.println("redirect-jsp");
        return "redirect:/save/jump";
    }

    @RequestMapping("baidu")
    public String baidu(){
        System.out.println("baidu");
        return "redirect:https://www.bilibili.com/";
    }


}
