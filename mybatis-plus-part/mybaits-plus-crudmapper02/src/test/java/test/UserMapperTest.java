package test;


import cn.wangye.Main;
import cn.wangye.mapper.UserMapper;
import cn.wangye.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest(classes = Main.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        User user = new User(121,"wu",21,"1212");
        int rowCount = userMapper.insert(user);
        //如果id是空的话，会使用雪花算法帮助我们生成
        //如果id有数据会使用我们的数据作为id,不再使用雪花生成
        System.out.println("rowCount" + rowCount);
    }


    @Test
    public void delete(){
        List<Integer> list = new ArrayList<>();
        list.add(121);
        list.add(5);
//        int count = userMapper.deleteBatchIds(list);
        Map<String, Object> map = new HashMap<>();
        map.put("name","xioaming");
        map.put("id",400855042);//key同名覆盖情况
        //根据columMap条件，删除同时满足条件的数据 sql语句是使用where .. and .. 进行拼接的
        int count = userMapper.deleteByMap(map);
        System.out.println(count);
    }


    @Test
    public void update(){
        User user = new User(-857436158, "wang", 22, "27368@qq.com");

//        int count = userMapper.updateById(user);

//        改变其余属性值，但是字段id的数据并没有发生什么变化
//        拼接的sql = UPDATE user SET name=?, age=?, email=?
        int count = userMapper.update(user,null);
        System.out.println(count);
    }

    @Test
    public void select(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//     SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? , ? )
//        List<User> userList = userMapper.selectBatchIds(list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("age",22);
        map.put("id",2);
//        SELECT id,name,age,email FROM user WHERE id = ? AND age = ?
        List<User> userList = userMapper.selectByMap(map);


        System.out.println(Arrays.toString(new List[]{userList}));




    }




}
