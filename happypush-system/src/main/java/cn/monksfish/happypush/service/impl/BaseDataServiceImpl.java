package cn.monksfish.happypush.service.impl;

import cn.monksfish.happypush.service.BaseDataService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Service
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    private WxMpUserService wxMpUserService;

    /**
     * 返回 openId 列表
     * @return 返回 openId 列表 并且加入缓存
     * @throws WxErrorException
     */
    @Override
    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "wxOpenIds")
    public List<String> wxOpenIds() throws WxErrorException {
        WxMpUserList wxMpUserList = wxMpUserService.userList(null);
        List<String> allOpenIds = new ArrayList<>(wxMpUserList.getOpenids());
        //  如果到达阈值，则接下来进行递归获取
        if (StringUtils.isNotEmpty(wxMpUserList.getNextOpenid())) {
            whenHasNext(wxMpUserService, allOpenIds, wxMpUserList.getNextOpenid());
        }
        return allOpenIds;
    }

    /**
     * 由于微信平台的阈值，这里采取递归调用，进行数据组装
     * 参考该文档：<a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Getting_a_User_List.html">...</a>
     * @param wxMpUserService 微信 user api
     * @param allOpenIds 暂存所有的用户openId
     * @param next 上一次查询结果的结尾
     * @throws WxErrorException 异常
     */
    public void whenHasNext(WxMpUserService wxMpUserService, List<String> allOpenIds, String next) throws WxErrorException {
        WxMpUserList wxMpUserList = wxMpUserService.userList(next);
        allOpenIds.addAll(wxMpUserList.getOpenids());
        while (StringUtils.isNotEmpty(wxMpUserList.getNextOpenid())) {
            whenHasNext(wxMpUserService, allOpenIds, wxMpUserList.getNextOpenid());
        }
    }
}
