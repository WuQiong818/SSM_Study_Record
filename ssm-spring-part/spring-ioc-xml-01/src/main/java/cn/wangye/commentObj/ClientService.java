package cn.wangye.commentObj;

public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    //静态工厂的好处，我不需要进行工厂类的实例化就可以进行类里面创建实例方法的调用了。
    public static ClientService createInstance() {

        return clientService;
    }
}
