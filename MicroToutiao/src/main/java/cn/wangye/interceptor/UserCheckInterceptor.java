package cn.wangye.interceptor;

import cn.wangye.controller.PortalController;
import cn.wangye.controller.UserController;
import cn.wangye.utils.JwtHelper;
import cn.wangye.utils.Result;
import cn.wangye.utils.ResultCodeEnum;
import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//这里编写一个拦截器效验token的类，判断是否有token以及token是否过期
@Component
public class UserCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token) || jwtHelper.isExpiration(token)){
            Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
//            这个应该是用来提醒用户的机制
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            response.getWriter().print(json);//打印到前端控制台上
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
