package cn.wangye.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wangye.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author wang'ye
 * @description 针对表【news_user】的数据库操作Mapper
 * @createDate 2023-12-08 20:31:15
 * @Entity cn.wangye.pojo.User
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> selectUidByUsernameAndUserPwd(@Param("username") String username, @Param("userPwd") String userPwd);

    //    验证用户名是否存在
    List<User> selectUidByUsername(@Param("username") String username);

    //    通过用户和密码查询所有的数据
    List<User> selectAllByUsernameAndUserPwd(@Param("username") String username, @Param("userPwd") String userPwd);

}




