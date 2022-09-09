package cn.monksfish.happypush.manager;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WxPushManager {

    @Autowired
    private WxMpService wxMpService;

    public void send() throws WxErrorException {
        WxMpTemplateMsgService templateMsgService = wxMpService.getTemplateMsgService();
        List<WxMpTemplate> allPrivateTemplate = templateMsgService.getAllPrivateTemplate();

    }
}
