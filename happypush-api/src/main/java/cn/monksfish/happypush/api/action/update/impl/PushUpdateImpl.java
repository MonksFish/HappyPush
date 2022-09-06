package cn.monksfish.happypush.api.action.update.impl;

import cn.monksfish.happypush.api.action.ContainerAction;
import cn.monksfish.happypush.api.action.update.PushUpdate;
import cn.monksfish.happypush.api.action.update.base.impl.AbstractUpdate;
import cn.monksfish.happypush.api.client.impl.PushClient;
import cn.monksfish.happypush.api.model.mo.push.PushMO;
import cn.monksfish.happypush.api.model.to.push.PushTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 小沙弥
 * @description 推送更新行为实现
 * @date 2022/9/2 3:30 下午
 */
public class PushUpdateImpl extends AbstractUpdate<PushTO, PushClient, PushMO> implements PushUpdate {

    private static final PushMO PUSH_MO = new PushMO();

    @Override
    public PushUpdate push(PushTO pushTO) {
        PUSH_MO.setMethodName(Thread.currentThread().getStackTrace()[1].getMethodName());
        PUSH_MO.setPushTO(pushTO);
        return this;
    }

    @Override
    protected PushClient getClient() {
        return ContainerAction.getBean(PushClient.class);
    }

    @Override
    protected PushMO getUpdateModel() {
        return PUSH_MO;
    }

}
