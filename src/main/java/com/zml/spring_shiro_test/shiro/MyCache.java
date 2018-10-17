package com.zml.spring_shiro_test.shiro;

import com.zml.spring_shiro_test.cache.ICacheClient;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyCache implements Cache {
    private static final String prefixStr = "shiro_";
    private ICacheClient cacheClient;
    public MyCache(ICacheClient cacheClient){
        this.cacheClient = cacheClient;
    }

    public String getKey(Object o){
        return prefixStr+o.toString();
    }
    @Override
    public Object get(Object o) throws CacheException {
        return cacheClient.get(getKey(o));
    }

    @Override
    public Object put(Object o, Object o2) throws CacheException {
        return cacheClient.set(getKey(o),o2);
    }

    @Override
    public Object remove(Object o) throws CacheException {
        return cacheClient.delete(getKey(o));
    }

    @Override
    public void clear() throws CacheException {

        cacheClient.delete(getKey("")+"*");
    }

    @Override
    public int size() {
        return cacheClient.size().intValue();
    }

    @Override
    public Set keys() {
        Set<String> strings = cacheClient.keySet(prefixStr + "*");

        return strings;
    }

    @Override
    public Collection values() {
        List list = new ArrayList();
        Set<String> strings = cacheClient.keySet(prefixStr + "*");
        strings.forEach(str->{
            list.add(cacheClient.get(str));
        });
        return list;
    }
}
