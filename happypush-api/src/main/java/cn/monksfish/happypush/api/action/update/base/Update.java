package cn.monksfish.happypush.api.action.update.base;

import cn.monksfish.happypush.api.model.RpcResultTO;
import cn.monksfish.happypush.api.model.to.BaseTO;

/**
 * @author 小沙弥
 * @description 定义更新行为
 * @date 2022/9/2 3:35 下午
 */
public interface Update<T extends BaseTO> {


    /**
     * 更新行为保存
     */
    RpcResultTO<T> save();

}
