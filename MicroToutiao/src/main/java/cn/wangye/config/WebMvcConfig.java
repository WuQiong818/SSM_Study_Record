package cn.wangye.config;

import cn.wangye.interceptor.UserCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private UserCheckInterceptor userCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        当访问headline下的路径,就进行token检验;
        registry.addInterceptor(userCheckInterceptor).addPathPatterns("/headline/**");
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
}
