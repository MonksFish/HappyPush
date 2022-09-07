package cn.monksfish.happypush.service;

import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;

/**
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
public interface BaseDataService {
    List<String> wxOpenIds() throws WxErrorException;
}
