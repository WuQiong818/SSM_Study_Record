package cn.wangye.cookie;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("cookie")
public class CookieController {

    @RequestMapping("get")
    public String data(@CookieValue String cookieName){
        System.out.println(cookieName);
        return cookieName;
    }
    @RequestMapping("create")
    public String createCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("cookieName", "root");
//       如果我们创建cookie不设置路径的话，会默认是一级路径；
        response.addCookie(cookie);
        return "cookie创建成功！";
    }
}
