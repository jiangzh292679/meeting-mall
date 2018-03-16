package com.stylefeng.guns.rest.modular.system.util;

import com.stylefeng.guns.rest.modular.system.pojo.User;

/**
 * @Author：jiangzh
 * @Descriptor：当前登陆用户信息访问
 * @Date： Create in 14:55 2018/3/13
 * @Modified by：
 */
public class CurrentUserUtils {

    // 使用一个Threadlocal模拟Session，用来存储数据
    private static ThreadLocal<User> threadLocal = new ThreadLocal();

    public static void setUser(User user){
        threadLocal.set(user);
    }

    public static User getUser(){
        return threadLocal.get();
    }

    public static void removeUser(){
        threadLocal.remove();
    }

}
