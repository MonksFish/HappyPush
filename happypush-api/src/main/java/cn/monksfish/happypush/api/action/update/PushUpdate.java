package cn.monksfish.happypush.api.action.update;

import cn.monksfish.happypush.api.model.to.PushTO;

/**
 * @author 小沙弥
 * @description 推送更新行为
 * @date 2022/9/2 10:41 上午
 */
public interface PushUpdate extends Update<PushTO> {

    /**
     * 推送消息
     * @return 推送更新行为
     */
    PushUpdate push();

}
