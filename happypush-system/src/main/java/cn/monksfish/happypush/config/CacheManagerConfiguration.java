package cn.monksfish.happypush.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 缓存配置
 * @author cocowwy.cn
 * @create 2022-05-05-11:45
 */
@Configuration
public class CacheManagerConfiguration {
    /**
     * 注入Redission
     * @param url redis地址
     * @return RedissonClient
     */
    @Bean("redissonClient")
    RedissonClient redisson(@Value("${redis.url}") String url,
                            @Value("${redis.pwd}") String pwd) {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("redis 地址无效");
        }
        Config config = new Config();
        config.useSingleServer().setAddress(url).setClientName("root").setPassword(pwd);
        return Redisson.create(config);
    }

    /**
     * SpringCache 与 redis 整合
     * @param redissonClient redissonClient
     * @return 缓存管理器
     */
    @Bean("redisCacheManager")
    CacheManager cacheManager(RedissonClient redissonClient) {
        return new RedissonSpringCacheManager(redissonClient);
    }
}
