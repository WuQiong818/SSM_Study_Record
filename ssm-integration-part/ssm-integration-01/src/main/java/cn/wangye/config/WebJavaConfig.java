package cn.wangye.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@ComponentScan({"cn.wangye.controller","cn.wangye.exceptionHandler"})
@EnableWebMvc//这个注解做了三件事情 :配置handlerMapping和handlerAdapter、处理json数据的返回
//handlerMapping--> RequestMappingHandlerMapping
//handlerAdapt --> RequestAdaptHandlerMapping
/**
 * 1.扫描对应的controller
 * 2.扫描全局异常处理器
 * 3.handlerMapping handlerAdapter的装配
 * 4.静态资源处理
 * 5.jsp视图解析器前后缀
 * 6.json处理器
 * 7.拦截器
 */
public class WebJavaConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view",".jsp");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addWebRequestInterceptor().addPathPatterns().excludePathPatterns();
//    }

    /*    @Bean
    public HandlerAdapter handlerAdapter(){
        HandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        return handlerAdapter;
    }

    @Bean
    public HandlerMapping handlerMapping(){
        HandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        return handlerMapping;
    }*/



}
