package com.zzp.lc.mq.listeners;

import com.alibaba.fastjson.JSON;
import com.zzp.lc.enums.LcMessageEventEnum;
import com.zzp.lc.vo.LcMessage;
import com.zzp.ls.event.handler.Handler;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 消息监听器
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@Component
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

        try {
            if (StringUtils.isBlank(msg)) {
                logger.error("consume -> msg为空不做任何处理");
                return;
            }

            LcMessage lcMessage = JSON.parseObject(msg, LcMessage.class);

            if (StringUtils.isBlank(lcMessage.getEvent())) {
                logger.error("consume -> event为空不做任何处理");
                return;
            }

            String beanName = LcMessageEventEnum.fromClassPath(lcMessage.getEvent());
            if (StringUtils.isBlank(beanName)) {
                logger.error("consume -> beanName为空不做任何处理");
                return;
            }

            Handler handler = (Handler) applicationContext.getBean(beanName);
            handler.handle(lcMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
