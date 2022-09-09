package cn.monksfish.happypush.config;

import cn.monksfish.happypush.utils.JsonUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * wechat mp properties
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
@ConfigurationProperties(prefix = "wxconf")
public class WxMpProperties {
    /**
     * 是否使用redis存储access token
     */
    private boolean useRedis;

    /**
     * redis 配置
     */
    private RedisConfig redisConfig;

    @Data
    public static class RedisConfig {
        /**
         * redis服务器 主机地址
         */
        private String address;
        /**
         * redis服务器 密码
         */
        private String password;

        /**
         * redis 服务连接超时时间
         */
        private Integer timeout;
    }

    /**
     * 多个公众号配置信息
     */
    private List<MpConfig> configs;

    @Data
    public static class MpConfig {
        /**
         * 设置微信公众号的appid
         */
        private String appId;

        /**
         * 设置微信公众号的app secret
         */
        private String secret;

        /**
         * 设置微信公众号的token
         */
        private String token;

        /**
         * 设置微信公众号的EncodingAESKey
         */
        private String aesKey;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
