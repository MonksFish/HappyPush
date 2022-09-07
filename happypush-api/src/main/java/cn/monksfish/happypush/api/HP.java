package cn.monksfish.happypush.api;

import cn.monksfish.happypush.api.context.FactoryContext;
import cn.monksfish.happypush.api.factory.PushFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * @author 小沙弥
 * @description Happypush系统远程调用客户端
 * @date 2022/9/2 10:23 上午
 */
public class HP {

    public static PushFactory push = FactoryContext.pushFactory;


}
