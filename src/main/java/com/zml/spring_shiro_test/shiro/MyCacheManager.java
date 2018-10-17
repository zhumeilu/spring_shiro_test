package com.zml.spring_shiro_test.shiro;

import com.zml.spring_shiro_test.cache.ICacheClient;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.ConcurrentHashMap;

public class MyCacheManager implements CacheManager {
    private static ConcurrentHashMap<String,Cache> map = new ConcurrentHashMap();
    @Getter
    @Setter
    private ICacheClient cacheClient;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {

        Cache cache = map.get(s);

        if(cache==null){
            cache = new MyCache(cacheClient);
            map.put(s,cache);
        }
        return cache;
    }

}
