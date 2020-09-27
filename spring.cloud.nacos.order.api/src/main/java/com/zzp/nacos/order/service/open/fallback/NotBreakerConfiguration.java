package com.zzp.nacos.order.service.open.fallback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
                JSONObject httpResult = this.convertJsonObject(json);
                Integer status = this.getStatus(httpResult);
                String message = this.getMessage(httpResult);
                if (status != null && status.equals(500)) {
                    exception = new HystrixBadRequestException(this.filterMessage(message));
                } else {
                    exception = new RuntimeException(message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return exception;
        }

        private JSONObject convertJsonObject(String text) {
            return JSON.parseObject(text);
        }

        private Integer getStatus(JSONObject jsonObject) {
            return jsonObject.getInteger("status");
        }

        private String getMessage(JSONObject jsonObject) {
            return jsonObject.getString("message");
        }

        private String filterMessage(String message) {
            String result = message.replaceAll("FeignApiException:", "");
            return result;
        }
    }

}
