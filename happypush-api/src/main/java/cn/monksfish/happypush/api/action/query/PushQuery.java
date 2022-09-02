package cn.monksfish.happypush.api.action.query;

/**
 * @author 小沙弥
 * @description 推送查询行为
 * @date 2022/9/2 10:37 上午
 */
public interface PushQuery {


    /**
     * 根据id查询推送消息
     * @param id 消息id
     * @return 推送查询行为
     */
    PushQuery queryPushMessageById(Long id);

}
