package cn.wangye.interceptorHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

//拦截器类并没有什么特殊的注解进行标记，让拦截器类发挥作用的方法是在配置类实现addInterceptor方法
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        preHandler是在handlerAdapter调用对应handler方法是进行拦截的
//        任何时候都会执行，除非handlerMapping找不到对应的路径
//        真正意义上的拦截作用
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//postHandler是handler方法向HandlerAdapter响应数据的时候进行拦截的、
//        handler方法报错的时候不会执行
//        进行过滤或者处理作用
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        afterCompletion是DispatcherServlet向前端进行最后的响应的时候，拦截数据的;
//    一定会执行
        //        进行过滤或者处理作用
    }
}
