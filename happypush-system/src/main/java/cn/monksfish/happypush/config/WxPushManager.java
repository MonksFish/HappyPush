package cn.monksfish.happypush.config;


import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpUserQuery;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import me.chanjar.weixin.mp.config.impl.WxMpRedissonConfigImpl;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信推送工具
 *
 * @author yan_wenjie
 * @date 2022/9/5
 */
@Configuration
public class WxPushManager {
    @Autowired
    @Qualifier("redissonClient")
    private RedissonClient redissonClient;

    @Bean("WX")
    @DependsOn("redissonClient")
    public WxMpService wxMpImpl(@Value(value = "${wxconf.appid}") String appId,
                                @Value(value = "${wxconf.appsecret}") String appSecret) throws WxErrorException {
        WxMpDefaultConfigImpl wxMpRedissonConfig = new WxMpRedissonConfigImpl(redissonClient, "wx:config");
        wxMpRedissonConfig.setAppId(appId);
        wxMpRedissonConfig.setSecret(appSecret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpRedissonConfig);
        // 模板service
        WxMpTemplateMsgService templateMsgService = wxMpService.getTemplateMsgService();
        List<WxMpTemplate> allPrivateTemplate = templateMsgService.getAllPrivateTemplate();
        // 星标用户service
        List<WxUserTag> wxUserTags = wxMpService.getUserTagService().tagGet();
        List<String> openIds = new ArrayList<>();
        openIds.add("oJxVR6ezM9VBbHisXFiHWXVPeRD0");
        WxMpUserQuery wxMpUserQuery = new WxMpUserQuery(openIds);
        //关注用户service
        WxMpUserService userService = wxMpService.getUserService();
        WxMpUserList wxMpUserList = userService.userList(null);
        wxMpUserList.getOpenids().forEach(openId -> {
            try {
                System.out.println(userService.userInfo(openId).toString());
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
        });
        return wxMpService;
    }

    @Bean("wxMpUserService")
    @DependsOn("WX")
    public WxMpUserService wxMpUserService(WxMpService wxMpService) {
        return wxMpService.getUserService();
    }
}
