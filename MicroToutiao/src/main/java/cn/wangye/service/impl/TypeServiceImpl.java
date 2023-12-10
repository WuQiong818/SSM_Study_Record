package cn.wangye.service.impl;

import cn.wangye.mapper.HeadlineMapper;
import cn.wangye.pojo.Headline;
import cn.wangye.pojo.PortalVo;
import cn.wangye.service.HeadlineService;
import cn.wangye.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wangye.pojo.Type;
import cn.wangye.service.TypeService;
import cn.wangye.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wang'ye
 * @description 针对表【news_type】的数据库操作Service实现
 * @createDate 2023-12-08 20:31:15
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {


    @Autowired
    private TypeMapper typeMapper;


    @Override
    public Result findAllTypes() {
//        LambdaQueryWrapper<Type> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.select(Type::getTid, Type::getTname);
//        List<Type> list = typeMapper.selectList(lambdaQueryWrapper);
//        List<Type> list = typeMapper.selectList();

//        return Result.ok(list);
        return null;
    }


}




