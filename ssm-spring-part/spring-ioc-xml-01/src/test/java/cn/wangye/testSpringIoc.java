package cn.wangye;

import cn.wangye.ioc03.HappyComponent;
import cn.wangye.ioc05.Person;
import cn.wangye.ioc05.PersonFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringIoc {



    /*
    * 如何进行容器的创建
    * */

    public void createIoc(){

//方式一：实例化并且指定配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
//方式二：先实例化，再指定配置文件，之后刷新容器触发Bean实例化动作

//        ApplicationContext context1 = new ClassPathXmlApplicationContext();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocations("spring-03.xml");
        context.refresh();//调用ico和di的流程,触发刷新配置
    }



    /*
    * 如何在Ioc容器中获取组件Bean
    * */
    @Test
    public void getBeanFromIoc(){
//        创建IOC容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocations("spring-03.xml");
        context.refresh();
//        读取IOC容器
//        方式一:通过指定name进行组件的获取，name就是xml文件中配置的id
        HappyComponent bean = (HappyComponent) context.getBean("HappyComponent");

//        方式二：通过根据类型获取，bean1这种方法要求类型是唯一的，不能够重复。
        HappyComponent bean1 = context.getBean(HappyComponent.class);
        HappyComponent bean2 = context.getBean("HappyComponent",HappyComponent.class);
        bean2.doWork();
    }

    @Test
    public void getLifecycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        Person person = context.getBean("person", Person.class);
        context.close();
    }

    @Test
    public void FactoryBeanTest() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-05.xml");
        Person person =  context.getBean("person", Person.class);
        System.out.println(person);

    }


}
