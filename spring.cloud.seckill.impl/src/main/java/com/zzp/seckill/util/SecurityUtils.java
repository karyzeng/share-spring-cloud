package com.zzp.seckill.util;

import com.zzp.seckill.entity.SysUser;

/**
 * @Description 权限工具类
 * @Author Garyzeng
 * @since 2021.01.21
 **/
public class SecurityUtils {

    private static final ThreadLocal<SysUser> userLocal = new ThreadLocal<SysUser>();

    public static void setUser(SysUser user) {
        userLocal.set(user);
    }

    public static SysUser getUser() {
        return userLocal.get();
    }

    public static void remoceUser() {
        userLocal.remove();
    }

}
