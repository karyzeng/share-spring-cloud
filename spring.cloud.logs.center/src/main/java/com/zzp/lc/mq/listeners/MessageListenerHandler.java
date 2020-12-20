package com.zzp.lc.mq.listeners;

import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @Description 消息监听器
 * @Author Garyzeng
 * @since 2020.12.19
 **/
//@Component
@Deprecated
public class MessageListenerHandler implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(MessageListenerHandler.class);
    private static String TOPIC = "logsCenterTopic";
    private static String TAGS= "es_log_tags";

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(msgs)) {
            logger.info("receive blank msgs...");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = msgs.get(0);
        if (messageExt.getTopic().equals(TOPIC) && messageExt.getTags().equals(TAGS)) {
            // 消费逻辑
            String msg = new String(messageExt.getBody());
            consume(msg);
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    private void consume(String msg){

        logger.info("receive msg: {}.", msg);

    }

}
