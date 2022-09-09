package cn.monksfish.test.api;

import cn.monksfish.test.EmptyTestApplication;
import cn.monksfish.happypush.api.HP;
import cn.monksfish.happypush.api.action.ContainerAction;
import cn.monksfish.happypush.api.client.impl.PushClient;
import cn.monksfish.happypush.api.context.FactoryContext;
import cn.monksfish.happypush.api.factory.impl.PushFactoryImpl;
import cn.monksfish.happypush.api.model.to.push.PushTO;
import env.SpringBootEmptyEnv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小沙弥
 * @description Api层测试类
 * @date 2022/9/6 4:01 下午
 */
@RunWith(SpringRunner.class)
// 单元测试空的环境，具体需要加载哪些bean和组件使用Import导入
@SpringBootEmptyEnv(classes = EmptyTestApplication.class)
@Import({FactoryContext.class, PushFactoryImpl.class, ContainerAction.class, PushClient.class})
public class ApiTest {

    @Test
    public void addUser() {
        HP.push.createUpdate().push(new PushTO()).save();
    }

}
