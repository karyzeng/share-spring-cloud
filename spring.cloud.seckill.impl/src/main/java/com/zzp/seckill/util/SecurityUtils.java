package com.zzp.seckill.util;

/**
 * @Description 权限工具类
 * @Author Garyzeng
 * @since 2021.01.21
 **/
public class SecurityUtils {

    private static final ThreadLocal<String> userLocal = new ThreadLocal<String>();

    public static void setUser(String user) {
        userLocal.set(user);
    }

    public static String getUser() {
        return userLocal.get();
    }

    public static void remoceUser() {
        userLocal.remove();
    }

}
