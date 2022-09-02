package cn.monksfish.happypush.api.action.update.impl;

import cn.monksfish.happypush.api.action.update.PushUpdate;
import cn.monksfish.happypush.api.model.RpcResultDO;
import cn.monksfish.happypush.api.model.to.PushTO;

/**
 * @author 小沙弥
 * @description 推送更新行为实现
 * @date 2022/9/2 3:30 下午
 */
public class PushUpdateImpl implements PushUpdate {

    @Override
    public PushUpdate push() {
        return this;
    }

    @Override
    public RpcResultDO<PushTO> save() {
        return null;
    }
}
