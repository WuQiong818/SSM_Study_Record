package cn.wangye.service.impl;

import cn.wangye.utils.JwtHelper;
import cn.wangye.utils.MD5Util;
import cn.wangye.utils.Result;
import cn.wangye.utils.ResultCodeEnum;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wangye.pojo.User;
import cn.wangye.service.UserService;
import cn.wangye.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.wangye.utils.Result.build;

/**
 * @author wang'ye
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2023-12-08 20:31:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);
//        账号判断
        if (loginUser == null) {
//            账号错误
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

//        判断密码
        if (!StringUtils.isEmpty(user.getUserPwd())
                && loginUser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd()))) {
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            Map data = new HashMap();
            data.put("token", token);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        if (jwtHelper.isExpiration(token)) {
//            过期了
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        } else {
            Long userId = jwtHelper.getUserId(token);
            LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(User::getUid, userId);
            User user = userMapper.selectOne(lambdaQueryWrapper);
            /*这里会忽略了一种情况，就是用户的token没有过期，当时用户的id由于特殊的
             *  情况被删除了，所以再得到用户的id后仍然可能有失败的可能性
             * */
            if (user == null) {
                return Result.build(null, ResultCodeEnum.NOTLOGIN);
            } else {
                user.setUserPwd(null);
                user.setVersion(null);
                user.setIsDeleted(null);
                Map<String,Object> map = new HashMap<>();
                map.put("loginUser",user);
                return Result.ok(map);
            }

        }

    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (user == null) {
            return Result.ok(null);
        } else {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
    }

    @Override
    public Result register(User user) {
        Result result = checkUserName(user.getUsername());
        Integer code = result.getCode();
        if (code == 505) {
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }else{
//            用户数据没有被占用，将用户的相关信息插入到数据库中
            user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
            int count = userMapper.insert(user);
            System.out.println("插入数据了"+count);
            if (count == 1){
                return Result.ok(null);
            }else {
                return Result.build(null,ResultCodeEnum.USERNAME_USED);
            }
        }
    }

    /*public Result login(User user) {
        List<User> list = userMapper.selectUidByUsername(user.getUsername());

        if (list.isEmpty()){
//            返回数据501 账号错误
            return build(null, ResultCodeEnum.USERNAME_ERROR);
        }else{
            List<User> users = userMapper.selectAllByUsernameAndUserPwd(user.getUsername(), MD5Util.encrypt(user.getUserPwd()));
            System.out.println("用户名和密码 users="+users);
            if (users.isEmpty()){
//                返回数据503密码错误
                return build(null, ResultCodeEnum.USERNAME_ERROR);
            }else{
//                返回200 加上token
                String token = jwtHelper.createToken(Long.valueOf(users.get(0).getUid()));
                Map data = new HashMap();
                data.put("token",token);
                return Result.ok(data);
            }
        }
    }*/
}







































