package cn.monksfish.happypush.api.context;

import cn.monksfish.happypush.api.factory.PushFactory;
import org.springframework.stereotype.Component;


/**
 * @author 小沙弥
 * @description 推送领域工厂核心类
 * @date 2022/9/2 1:26 下午
 */
@Component
public class FactoryContext {

    /**
     * 推送领域工厂
     */
    public static PushFactory pushFactory;


    public FactoryContext(PushFactory pushFactory) {
        FactoryContext.pushFactory = pushFactory;
    }

}
