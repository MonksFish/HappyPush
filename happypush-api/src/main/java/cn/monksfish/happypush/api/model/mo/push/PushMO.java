package cn.monksfish.happypush.api.model.mo.push;

import cn.monksfish.happypush.api.model.mo.BaseMO;
import cn.monksfish.happypush.api.model.to.push.PushTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 小沙弥
 * @description 推送远程调用入参数
 * @date 2022/9/6 2:13 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PushMO extends BaseMO {


    /**
     * API层接收/输出模型
     */
    private PushTO pushTO;

}
