package com.zzp.seckill.config;

import com.zzp.seckill.Interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description web mvc配置
 * @Author Garyzeng
 * @since 2021.01.21
 **/
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/login/doLogin");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
