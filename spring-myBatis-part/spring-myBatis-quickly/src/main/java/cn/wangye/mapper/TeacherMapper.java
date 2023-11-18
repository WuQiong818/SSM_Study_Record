package cn.wangye.mapper;

import cn.wangye.pojo.Teacher;

/**
* @author wang'ye
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-11-16 16:44:19
* @Entity cn.wangye.pojo.Teacher
*/
    public interface TeacherMapper {

    int insert(Teacher record);

    int insertSelective(Teacher record);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher selectByPrimaryKey(Long id);


}
