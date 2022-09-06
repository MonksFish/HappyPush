package cn.monksfish.happypush.api.client.impl;

import cn.monksfish.happypush.api.client.Client;
import cn.monksfish.happypush.api.model.RpcResultTO;
import cn.monksfish.happypush.api.model.mo.push.PushMO;
import org.springframework.stereotype.Component;

/**
 * @author 小沙弥
 * @description 推送API客户端
 * @date 2022/9/6 10:58 上午
 */
@Component
public class PushClient implements Client {


    /**
     * 消息推送
     * @param pushMO 消息推送入参模型
     */
    public static RpcResultTO<Boolean> push(PushMO pushMO) {
        System.out.println(pushMO.getMethodName());
        return new RpcResultTO<>(true);
    }

}
