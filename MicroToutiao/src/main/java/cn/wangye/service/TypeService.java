package cn.wangye.service;

import cn.wangye.pojo.PortalVo;
import cn.wangye.pojo.Type;
import cn.wangye.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wang'ye
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-12-08 20:31:15
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();


}
