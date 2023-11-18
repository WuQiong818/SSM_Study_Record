package cn.wangye.mapper;

import cn.wangye.pojo.User;
import lombok.Value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
  
  int insertUser(User user);
  int insertUserByString(@Param("usernameTest")String username, @Param("passwordTest")String password);

  int updateById(User user);

  int deleteById(Integer id);

  User selectById(Integer id);

  List<User> selectAll();
}