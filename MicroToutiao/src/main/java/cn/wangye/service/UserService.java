package cn.wangye.service;

import cn.wangye.pojo.User;
import cn.wangye.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wang'ye
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-12-08 20:31:15
*/
public interface UserService extends IService<User> {

    public Result login(User user);

    public Result getUserInfo(String token);

    public Result checkUserName(String username);

    public Result register(User user);

}
