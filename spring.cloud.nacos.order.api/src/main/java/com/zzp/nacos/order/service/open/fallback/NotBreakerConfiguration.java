package com.zzp.nacos.order.service.open.fallback;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

/**
 * @Description feign自定义配置
 * @Author Garyzeng
 * @since 2020.09.26
 **/
public class NotBreakerConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new SpecialErrorDecoder();
    }

    public class SpecialErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                String json = Util.toString(response.body().asReader());
                System.out.println("测试异常：" + json);
                exception = new HystrixBadRequestException("decode测试异常");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return exception;
        }
    }

}
