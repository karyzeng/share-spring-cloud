package com.zzp.seckill.Interceptor;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.seckill.entity.SysUser;
import com.zzp.seckill.redis.RedisService;
import com.zzp.seckill.redis.UserKey;
import com.zzp.seckill.util.CookieUtils;
import com.zzp.seckill.util.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Description 权限拦截器
 * @Author Garyzeng
 * @since 2021.01.21
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(CookieUtils.COOKIE_NAME_TOKEN);
        if (StringUtils.isBlank(token) && request.getParameter(CookieUtils.COOKIE_NAME_TOKEN) != null) {
            token = request.getParameter(CookieUtils.COOKIE_NAME_TOKEN);
        }

        SysUser currentUser = redisService.get(UserKey.token, token, SysUser.class);
        if (currentUser == null) {
            throw new ApiException("当前登录凭证已失效");
        }
        // 延长redis有效期
        redisService.set(UserKey.token, token, currentUser);
        // 延长cookie有效期
        CookieUtils.addCookie(response, token);
        SecurityUtils.setUser(currentUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SecurityUtils.remoceUser();
    }
}
