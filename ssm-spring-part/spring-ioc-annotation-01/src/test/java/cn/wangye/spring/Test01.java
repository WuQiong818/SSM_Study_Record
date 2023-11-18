package cn.wangye.spring;

import cn.wangye.ioc1.CommonComponent;
import cn.wangye.ioc1.XxxController;
import cn.wangye.ioc2.BeanOne;
import cn.wangye.ioc3.SoldierController;
import cn.wangye.ioc4MVC.servlet.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-annotation-01.xml");
//        注解没有什么大的作用，唯一能够做的就是告知和改变类的id,对于类的类型不会改变
        CommonComponent component = (CommonComponent) context.getBean("component");
        System.out.println(component);

        XxxController controller = context.getBean(XxxController.class);
        System.out.println(controller);
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-annorarion-02.xml");
        BeanOne beanOne = context.getBean(BeanOne.class);
        BeanOne beanTwo = context.getBean(BeanOne.class);
        System.out.println(beanOne == beanTwo);
        context.close();
    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-annotation-03.xml");
        SoldierController soldierController = (SoldierController)context.getBean("soldierController");
        soldierController.getMessage();
    }

    @Test
    public void test04MVCPlus(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-annotation-04Plus.xml");
        Controller bean = context.getBean(Controller.class);
        System.out.println(bean);
        System.out.println(bean.selectAll());
    }

}
