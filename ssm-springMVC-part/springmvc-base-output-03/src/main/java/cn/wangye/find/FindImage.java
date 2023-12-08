package cn.wangye.find;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("test")
public class FindImage {

    @Autowired
    private ServletContext servletContext;
    @RequestMapping("findImage")
    public void fondImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始了");
//        失败
        RequestDispatcher rd = servletContext.getNamedDispatcher("images/mi.jpg");
        System.out.println(rd);
        rd.forward(request,response);
        System.out.println("结束了");

    }
}
