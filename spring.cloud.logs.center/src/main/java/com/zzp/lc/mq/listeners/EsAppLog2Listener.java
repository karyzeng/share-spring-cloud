package com.zzp.lc.mq.listeners;

import com.alibaba.fastjson.JSON;
import com.zzp.lc.vo.EsAppLog;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description Elasticsearch App日志信息监听器（测试发布订阅模型）
 * @Author Garyzeng
 * @since 2020.12.20
 **/
@Component
@RocketMQMessageListener(
        topic = "${rocketmq.topic}",
        consumerGroup = "${rocketmq.consumer.group2}",
        selectorExpression = "${rocketmq.tag-es-log}"
)
public class EsAppLog2Listener implements RocketMQListener<EsAppLog> {

    private static final Logger logger = LoggerFactory.getLogger(EsAppLog2Listener.class);

    @Override
    public void onMessage(EsAppLog esAppLog) {
        logger.info("onMessage -> 接受到消息：{}", JSON.toJSONString(esAppLog));
    }
}
