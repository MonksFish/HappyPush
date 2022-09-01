package cn.monksfish.happypush.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

/**
 * 缓存配置
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Configurable
public class CacheManagerConfiguration {

    /**
     * 注入Redission
     * @param url redis地址
     * @return
     */
    @Bean("redissonClient")
    RedissonClient redisson(@Value("${happypush.redis}") String url) {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("redis 地址无效");
        }
        Config config = new Config();
        config.useSingleServer().setAddress(url);
        return Redisson.create(config);
    }

    /**
     * SpringCache 与 redis 整合
     * @param redissonClient redissonClient
     * @return 缓存管理器
     */
    @Bean
    CacheManager cacheManager(RedissonClient redissonClient) {
        return new RedissonSpringCacheManager(redissonClient);
    }
}
