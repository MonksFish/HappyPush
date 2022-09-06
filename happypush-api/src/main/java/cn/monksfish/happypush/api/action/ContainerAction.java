package cn.monksfish.happypush.api.action;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 小沙弥
 * @description 目的是为了获取spring上下文
 * @date 2022/9/6 4:22 下午
 */
@Component
public class ContainerAction implements ApplicationContextAware {


    /**
     * spring上下文
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        ContainerAction.applicationContext = applicationContext;
    }

    /**
     * 从spring上下文中获取bean
     * @param beanClass bean class
     * @return bean实例
     */
    public static <C> C getBean(Class<C> beanClass) {
        return applicationContext.getBean(beanClass);
    }
}
