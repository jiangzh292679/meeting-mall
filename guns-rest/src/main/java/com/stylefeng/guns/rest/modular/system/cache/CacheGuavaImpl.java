package com.stylefeng.guns.rest.modular.system.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.stylefeng.guns.rest.modular.system.pojo.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author：jiangzh
 * @Descriptor：
 * @Date： Create in 14:16 2018/3/13
 * @Modified by：
 */
@Service("iCache")
public class CacheGuavaImpl<T> implements ICache<T>{

    private static LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(
                    new CacheLoader<String,String>() {
                        @Override
                        public String load(String key) throws Exception {
                            return "";
                        }
                    });

    @Override
    public void setCache(String key, String value) {
        loadingCache.put(key,value);
    }

    @Override
    public void setCache(String key, T value) {
        String jsonStr = JSON.toJSONString(value);
        setCache(key,jsonStr);
    }

    @Override
    public void setCache(String key, String value, long exprieTime) {
        // Guava不存在设置过期时间的说法
        setCache(key,value);
    }

    @Override
    public void setCache(String key, T value, long exprieTime) {
        setCache(key,value);
    }

    @Override
    public String getCacheStr(String key) {
        try {
            return loadingCache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public T getCache(String key,Class cls) {
        //Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        String jsonStr = getCacheStr(key);

        T result = (T)JSON.parseObject(jsonStr, cls);

        return result;
    }

    @Override
    public void removeCache(String key) {
        loadingCache.invalidate(key);
    }


}
