package cn.wangye.ioc3;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SoldierController {


    /*
     * 我们这里使用自动装配来实现DI的注入
     * 使用注解的方式直接在对应的装配中将加上@Autowired就可以了，不需要书写set方法
     *
     * */

    @Autowired
//    @Qualifier("autoService")
//    @Resource(name = "soldierService")
//    这样的缺点就是不能使用多态了，但是能够实现配对关系


    /*
    * @Autowired寻找的流程
    * 一开始会根据成员变量的类型去寻找对应Bean，如果找到唯一的会直接进行返回，
    * 如果是多个的话，对再次对Id进行配对，如果查询到的还是多个Bean就会直接进行报错
    * 方法多样，但是我们的目的是寻找到单一的Bean
    * */
    private Service soldierService;

    public void getMessage() {
        soldierService.getMessage();
    }
}