package cn.wangye.service;

import cn.wangye.pojo.Headline;
import cn.wangye.pojo.PortalVo;
import cn.wangye.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.logging.log4j.message.ReusableMessage;

/**
* @author wang'ye
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-12-08 20:31:15
*/
public interface HeadlineService extends IService<Headline> {



    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(String hid);

    Result publish( Headline headline);

    Result updateHeadline(Headline headline);

    Result removeByHid(Integer hid);
}
