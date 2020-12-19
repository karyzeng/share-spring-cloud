package com.zzp.lc.controller;

import com.alibaba.fastjson.JSON;
import com.zzp.lc.enums.LcMessageEventEnum;
import com.zzp.lc.vo.EsAppLog;
import com.zzp.lc.vo.LcMessage;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description IndexController
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @RequestMapping(value = "testSendMq", method = RequestMethod.GET)
    public String testSendMq() {
        try {
            EsAppLog esAppLog = new EsAppLog();
            esAppLog.setEsIndexName("lc-log-index");
            esAppLog.setAppName("logs-center");
            esAppLog.setHost("127.0.0.1");
            esAppLog.setPort("8088");
            esAppLog.setCreateTime(new Date());

            LcMessage<EsAppLog> lcMessage = new LcMessage<EsAppLog>(LcMessageEventEnum.LC_ES_APP_EVENT.getCode(), esAppLog);

            Message msg = new Message("logsCenterTopic", "es_log_tags", lcMessage.toString().getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = defaultMQProducer.send(msg);
            logger.info("sendResult：{}", JSON.toJSONString(sendResult));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
