package cn.wangye;

import cn.wangye.ioc3.config.MyConfiguration;
import cn.wangye.ioc3.servlet.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {


    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();
    }


    @Test
    public void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
         * 大明星唱歌不是白唱、白跳的，需要准备话筒、场地和收钱；
         * */
//        这在某种程度上说，也相当于是一种代理，在一个类中通过方法进行功能扩展，使得原有的类专注于核心业务。
        Class class1 = Class.forName("cn.wangye.BigStar");
//        构造方法的获取，是根据需求进行获取的，需要在getConstructor中填写形参类型进行获取的；
        BigStar bigStar = (BigStar) class1.getConstructor(String.class).newInstance("华仔");

        System.out.println("准备话筒，收钱");
        Method singMethod = class1.getMethod("sing", String.class);
        String result = (String) singMethod.invoke(bigStar, "忘情水11");

        System.out.println(result);
//        ---------------------------------
        System.out.println("准备场地，收钱");
        Method danceMethod = class1.getMethod("dance");
        danceMethod.invoke(bigStar);
    }

    @Test
    public void test03() {
        BigStar bigStar = new BigStar("华仔");
        Star proxy = ProxyUtil.createProxy(bigStar);
        System.out.println(proxy.sing("傲骨"));

        proxy.dance();

        Math.max(1,2);
    }

}



/**
 * 类的作用，创建传入对象的一个代理;
 * 针对于某一个类，根据接口进行创建。
 * 形参:
 * 被代理的明星对象
 * 返回值:
 * 生成的代理对象
 * 代理类的作用是工具，所以我们方法我们直接用static修饰;
 */
class ProxyUtil {
    //   进行一些功能的代理，帮助我们直接对核心业务的调用；
    //我需要在Proxy里面进行一些类的能力实现，包括核心业务和非核心业务
    /*
     * 必备信息：代理的对象，代理的方法
     * */
    public static Star createProxy(BigStar bigStar) {
//        bigStar.getClass().getInterfaces()
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),//参数一:用于指定用哪个类加载器，去加载生成的代理类
                new Class[]{Star.class},//参数二:指定接口，这些接口用于指定生成的代理类长什么即代理类中有哪些方法
                //参数三:用来指定生成的代理对象要干什么事情。
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("准备话筒，收钱");
                        } else if (method.getName().equals("dance")) {
                            System.out.println("准备场地，收钱");
                        }
                        return method.invoke(bigStar, args);
                    }
                });
        return star;
    }
}

interface Star {
    public String sing(String name);

    public void dance();
}

//大明星类
class BigStar implements Star {
    String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(this.name + "正在唱" + name);
        return "感谢大家,鞠躬";
    }

    @Override
    public void dance() {
        System.out.println("正在跳舞");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BigStar{" +
                "name='" + name + '\'' +
                '}';
    }


}