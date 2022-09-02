package cn.monksfish.happypush.api.factory;

import cn.monksfish.happypush.api.action.query.PushQuery;
import cn.monksfish.happypush.api.action.update.PushUpdate;

/**
 * @author 小沙弥
 * @description 推送领域工厂
 * @date 2022/9/2 10:36 上午
 */
public interface PushFactory {

    /**
     * 构建推送查询行为
     * @return 推送查询行为
     */
    PushQuery createQuery();


    /**
     * 构建推送更新行为
     * @return 推送更新行为
     */
    PushUpdate createUpdate();

}
