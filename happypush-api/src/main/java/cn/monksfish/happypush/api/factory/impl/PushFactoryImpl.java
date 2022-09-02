package cn.monksfish.happypush.api.factory.impl;

import cn.monksfish.happypush.api.action.query.PushQuery;
import cn.monksfish.happypush.api.action.query.impl.PushQueryImpl;
import cn.monksfish.happypush.api.action.update.PushUpdate;
import cn.monksfish.happypush.api.action.update.impl.PushUpdateImpl;
import cn.monksfish.happypush.api.factory.PushFactory;
import org.springframework.stereotype.Component;

/**
 * @author 小沙弥
 * @description 推送领域工厂实现
 * @date 2022/9/2 10:36 上午
 */
@Component
public class PushFactoryImpl implements PushFactory {


    @Override
    public PushQuery createQuery() {
        return new PushQueryImpl();
    }

    @Override
    public PushUpdate createUpdate() {
        return new PushUpdateImpl();
    }

}
