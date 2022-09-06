import cn.monksfish.happypush.HappypushApplication;
import cn.monksfish.happypush.api.HP;
import cn.monksfish.happypush.api.model.to.push.PushTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 小沙弥
 * @description Api层测试类
 * @date 2022/9/6 4:01 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HappypushApplication.class)
public class ApiTest {


    @Test
    public void addUser() {
        HP.push.createUpdate().push(new PushTO()).save();
    }

}
