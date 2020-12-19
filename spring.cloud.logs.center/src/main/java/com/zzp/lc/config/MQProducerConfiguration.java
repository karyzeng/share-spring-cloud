package com.zzp.lc.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description RocketMQ生产者配置
 * @Author karyzeng
 * @since 2020.12.18
 **/
@Configuration
public class MQProducerConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(MQProducerConfiguration.class);

    @Value("${rocketmq.groupName}")
    private String groupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.producer.maxMessageSize}")
    private Integer maxMessageSize;

    @Value("${rocketmq.producer.sendMsgTimeout}")
    private Integer sendMsgTimeout;

    @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
    private Integer retryTimesWhenSendFailed;

    @Bean
    @ConditionalOnMissingBean
    public DefaultMQProducer defaultMQProducer() throws RuntimeException {
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        //如果需要同一个 jvm 中不同的 producer 往不同的 mq 集群发送消息，需要设置不同的 instanceName
        //producer.setInstanceName(instanceName);
        //发送消息的最大限制
        producer.setMaxMessageSize(this.maxMessageSize);
        //发送消息超时时间
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        //发送消息失败，设置重试次数，默认为 2 次
        producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
        try {
            producer.start();
            logger.info("producer is started. groupName:{}, namesrvAddr: {}", groupName, namesrvAddr);
        } catch (MQClientException e) {
            logger.error("failed to start producer.", e);
            throw new RuntimeException(e);
        }
        return producer;
    }

}
