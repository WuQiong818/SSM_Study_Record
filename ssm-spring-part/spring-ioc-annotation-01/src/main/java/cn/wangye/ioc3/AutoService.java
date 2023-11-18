package cn.wangye.ioc3;

@org.springframework.stereotype.Service
public class AutoService implements Service{
    @Override
    public void getMessage() {
        System.out.println("这是伪造的");
    }
}
