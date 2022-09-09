package cn.monksfish.happypush.handler;

import cn.monksfish.happypush.service.BaseDataService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 数据预热处理
 *
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class DataWarmUpHandler implements CommandLineRunner {
    @Autowired
    private WxMpUserService wxMpUserService;
    @Autowired
    private BaseDataService baseDataService;

    /**
     * 异步更新数据库信息
     * @param allOpenIds openId集合
     * @throws WxErrorException
     */
//    @Async
    public void persistenceDB(List<String> allOpenIds) throws WxErrorException {
        // 用户信息进行入库
        List<WxMpUser> wxMpUsers = wxMpUserService.userInfoList(allOpenIds);
        Map<String, WxMpUser> openIdMapUserInfo = wxMpUsers.stream().collect(Collectors.toMap(WxMpUser::getOpenId, Function.identity()));
    }

    /**
     * 项目启动后，数据预热，刷新等操作
     * @param args ApplicationArguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // 预热进redis
        List<String> openIds = baseDataService.wxOpenIds();
        persistenceDB(openIds);
    }
}
