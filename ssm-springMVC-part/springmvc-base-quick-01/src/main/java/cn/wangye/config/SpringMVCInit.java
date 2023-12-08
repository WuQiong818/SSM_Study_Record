package cn.wangye.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //    指定service / mapper层的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }


    /*
     * 指定springmvc的配置类,这样Springmvc会帮助我们自动创建ioc容器，而不是像之前那样，
     * 在测试类中去使用一下代码创建ioc容器。
     * ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-annotation-04Plus.xml");
     * Controller bean = context.getBean(Controller.class);
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfig.class};
    }


    /**
     * 设置dispatcherServlet的处理路径!
     * 一般情况下为 / 代表处理所有请求!
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
