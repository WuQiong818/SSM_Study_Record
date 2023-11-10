package cn.wangye.commentObj;

public class DefaultServiceLocator {
    private static ClientServiceImpl clientService = new ClientServiceImpl();


    //    这里的创建方法不再是实例化了
    /*
    *
    * */
    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}
