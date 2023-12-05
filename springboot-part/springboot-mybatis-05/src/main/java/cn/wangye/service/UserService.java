package cn.wangye.service;

import cn.wangye.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

//   在这里测试一下事务的回滚机制


    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int deleteUserById(Integer id) {
        System.out.println("即将执行删除SQL");
        int result = userMapper.deleteById(id);
        System.out.println("删除成功");
//        int num = 1/0;
        return result;
    }
}
