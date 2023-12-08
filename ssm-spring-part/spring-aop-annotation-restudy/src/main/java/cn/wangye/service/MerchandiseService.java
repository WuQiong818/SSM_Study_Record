package cn.wangye.service;

import org.springframework.stereotype.Service;
@Service
public class MerchandiseService {

    public String getList(){
        System.out.println("getList()方法执行了");
        return "OK";
    }
}
