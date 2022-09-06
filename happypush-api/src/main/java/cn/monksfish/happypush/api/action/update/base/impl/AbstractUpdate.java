package cn.monksfish.happypush.api.action.update.base.impl;

import cn.monksfish.happypush.api.action.update.base.Update;
import cn.monksfish.happypush.api.client.Client;
import cn.monksfish.happypush.api.model.RpcResultTO;
import cn.monksfish.happypush.api.model.mo.BaseMO;
import cn.monksfish.happypush.api.model.to.BaseTO;
import cn.monksfish.happypush.plugin.util.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;


/**
 * @author 小沙弥
 * @description 更新动作基础实现
 * @param <T> 限定API层的更新动作模型只能是BaseTO以及BaseTO的子类
 * @date 2022/9/5 6:15 下午
 */
public abstract class AbstractUpdate<T extends BaseTO, C extends Client, M extends BaseMO> implements Update<T> {

    @Override
    public RpcResultTO<T> save() {
        // 预留的一个扩展点，可以在这里做一些特定的操作, 比如在模型中设置特定字段, 做特殊处理
        beforeSave();
        // 借助SPI机制的原因：因为方法调用可以分为本地调用和远程调用，远程调用又根据不同的框架有不同的调用方式，所以通过SPI的配置来做不同的处理
        try {
            // 通过反射找到client那一层的方法调用，在client那一层借助策略和SPI机制去真正发起调用
            return (RpcResultTO<T>) ReflectionUtil.invoke(getClient(), getUpdateModel().getMethodName(), getUpdateModel());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取远程调用客户端
     * 前提: 客户端已经被加载到容器中
     */
    protected abstract C getClient();


    /**
     * 获取远程调用需要的入参
     */
    protected abstract M getUpdateModel();


    /**
     * 预留的扩展点，可以做前置特殊处理
     */
    protected void beforeSave() {}

}
