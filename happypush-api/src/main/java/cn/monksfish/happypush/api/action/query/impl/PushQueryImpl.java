package cn.monksfish.happypush.api.action.query.impl;

import cn.monksfish.happypush.api.action.query.PushQuery;

/**
 * @author 小沙弥
 * @description 推送查询行为实现
 * @date 2022/9/2 10:37 上午
 */
public class PushQueryImpl implements PushQuery {

    @Override
    public PushQuery queryPushMessageById(Long id) {
        return this;
    }

}
