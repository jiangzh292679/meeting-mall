package com.stylefeng.guns.rest.modular.system.cache;

/**
 * @Author：jiangzh
 * @Descriptor：
 * @Date： Create in 14:12 2018/3/13
 * @Modified by：
 */
public interface ICache<T> {

    void setCache(String key,String value);

    void setCache(String key,T value);

    void setCache(String key,String value,long exprieTime);

    void setCache(String key,T value,long exprieTime);

    String getCacheStr(String key);

    T getCache(String key,Class cls);

    void removeCache(String key);

}
