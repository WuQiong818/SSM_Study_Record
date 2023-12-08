package cn.wangye.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"cn.wangye.controller","cn.wangye.error"})
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        当通过RequestMapping进行静态资源查找的时候，如果找不到会在webapp目录下进行资源的查找
        configurer.enable();
    }
}
