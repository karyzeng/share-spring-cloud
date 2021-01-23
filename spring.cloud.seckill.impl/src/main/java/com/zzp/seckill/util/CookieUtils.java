package com.zzp.seckill.util;

import com.zzp.seckill.redis.UserKey;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description Cookie工具类
 * @Author karyzeng
 * @since 2021.01.23
 **/
public class CookieUtils {

    public static final String COOKIE_NAME_TOKEN = "seckill-token";

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public static void addCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

}
