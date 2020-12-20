package com.zzp.lc.mq.listeners;

import com.alibaba.fastjson.JSON;
import com.zzp.lc.vo.EsAppLog;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description Elasticsearch App日志信息监听器
 * @Author Garyzeng
 * @since 2020.12.20
 **/
@Component
@RocketMQMessageListener(
        topic = "${rocketmq.topic}",
        consumerGroup = "${rocketmq.consumer.group}",
        selectorExpression = "${rocketmq.tag-es-log}"
)
public class EsAppLogListener implements RocketMQListener<EsAppLog> {

    private static final Logger logger = LoggerFactory.getLogger(EsAppLogListener.class);

    @Override
    public void onMessage(EsAppLog esAppLog) {
        logger.info("onMessage -> 接受到消息：{}", JSON.toJSONString(esAppLog));
    }
}
