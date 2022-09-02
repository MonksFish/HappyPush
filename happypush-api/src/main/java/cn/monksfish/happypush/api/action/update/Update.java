package cn.monksfish.happypush.api.action.update;

import cn.monksfish.happypush.api.model.RpcResultDO;

/**
 * @author 小沙弥
 * @description 定义更新行为
 * @date 2022/9/2 3:35 下午
 */
public interface Update<T> {


    RpcResultDO<T> save();

}
