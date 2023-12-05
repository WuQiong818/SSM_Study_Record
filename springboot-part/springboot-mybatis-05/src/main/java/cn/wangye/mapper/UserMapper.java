package cn.wangye.mapper;

import cn.wangye.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> queryList();


    public int deleteById(Integer id);
}
