package cn.wangye.service.impl;


import cn.wangye.pojo.PortalVo;
import cn.wangye.utils.JwtHelper;
import cn.wangye.utils.Result;
import cn.wangye.utils.ResultCodeEnum;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wangye.pojo.Headline;
import cn.wangye.service.HeadlineService;
import cn.wangye.mapper.HeadlineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wang'ye
 * @description 针对表【news_headline】的数据库操作Service实现
 * @createDate 2023-12-08 20:31:15
 */
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
        implements HeadlineService {

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result findNewsPage(PortalVo portalVo) {
        System.out.println(portalVo.getKeyWords());
        System.out.println(portalVo.getType());

//        在执行sql语句之前要进行数据的验证，例如字符串不能为0或者null,
//        LambdaQueryWrapper<Headline> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.like(!StringUtils.isEmpty(portalVo.getKeyWords()), Headline::getTitle, portalVo.getKeyWords())
//                .eq(portalVo.getType() != null, Headline::getType, portalVo.getType());

        IPage<Headline> page = new Page(portalVo.getPageNum(), portalVo.getPageSize());
//        headlineMapper.selectPage(page, lambdaQueryWrapper);
        headlineMapper.mySelectPage(page,portalVo);
//        这里需要自己定义方法，如果是如果关键字有

        System.out.println("这个是总记录数" + page.getRecords());

//        不知道使用什么容器，把数据给封装起来
        Map<String, Object> map = new HashMap<>();
        map.put("pageData", page.getRecords());
        map.put("pageNum", page.getCurrent());
        map.put("pageSize", page.getSize());
        map.put("totalPage", page.getPages());
        map.put("totalSize", page.getTotal());

//        外边套一层
        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageInfo", map);
        return Result.ok(pageInfo);
    }

    @Override
    public Result showHeadlineDetail(String hid) {
        Map map = headlineMapper.selectDetailMap(Integer.valueOf(hid));
        System.out.println(map.toString());


        Headline headline = new Headline();
        headline.setHid(Integer.valueOf(hid));
        headline.setPageViews((Integer) map.get("pageViews") + 1);
        headline.setVersion((Integer) map.get("version"));
        System.out.println("--headline--" + headline);
        LambdaQueryWrapper<Headline> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Headline::getHid, hid);
        headlineMapper.updateById(headline);
//        headlineMapper.update(headline,lambdaQueryWrapper);


//        返回结果一般是使用map容器进行进一步的封装的，形成json中的key-value的形式
        Map<String, Object> pageInfoMap = new HashMap<>();
        pageInfoMap.put("headline", map);
        return Result.ok(pageInfoMap);//这样直接放的返回结果一定是有毛病的，try
    }


    @Override
    public Result publish(Headline headline) {
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headline.setPageViews(0);
        headlineMapper.insert(headline);
        return Result.ok(null);
    }


    @Override
    public Result updateHeadline(Headline headline) {
        headline.setUpdateTime(new Date());
        int count = headlineMapper.updateById(headline);
        System.out.println("更新了"+count);
        return Result.ok(null);
    }

    @Override
    public Result removeByHid(Integer hid) {
        int count = headlineMapper.deleteById(hid);
        System.out.println("headline删除了"+count);
        return Result.ok(null);
    }
}



























