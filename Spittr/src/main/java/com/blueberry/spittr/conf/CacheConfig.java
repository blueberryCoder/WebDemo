package com.blueberry.spittr.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/30/2016.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 使用多个缓存管理器。
     *
     * @return
     */
    @Bean
    public CacheManager cacheManager(net.sf.ehcache.CacheManager cm,
                                     javax.cache.CacheManager jcm,
                                     RedisTemplate rt) {
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<>();
        managers.add(new JCacheCacheManager(jcm));
        managers.add(new EhCacheCacheManager(cm));
        managers.add(new RedisCacheManager(rt));
        cacheManager.setCacheManagers(managers);
        return cacheManager;
    }

    /**
     * net.sf.ehcache.CacheManager
     *
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean
                = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }


    /**
     * java.cache.CacheManager
     *
     * @return
     */
    @Bean
    public javax.cache.CacheManager jCacheManager() {
        javax.cache.CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        MutableConfiguration<Object, Object> mutableConfiguration
                = new MutableConfiguration<>();
        mutableConfiguration.setStoreByValue(false);
        if(cacheManager.getCache("userCache")==null){
            cacheManager.createCache("userCache", mutableConfiguration);
        }
        return cacheManager;

    }

    /**
     * Redis 连接工厂。
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory
                = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName();
//        jedisConnectionFactory.setPort();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisCF) {
        RedisTemplate<String, String> redisTemplate
                = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCF);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
