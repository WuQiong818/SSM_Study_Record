package cn.wangye.mapper;

import cn.wangye.pojo.Headline;
import cn.wangye.pojo.PortalVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.Map;

/**
* @author wang'ye
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2023-12-08 20:31:15
* @Entity cn.wangye.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    Map selectDetailMap(Integer hid);

    IPage<Headline> mySelectPage(IPage<Headline> page, PortalVo portalVo);
}




