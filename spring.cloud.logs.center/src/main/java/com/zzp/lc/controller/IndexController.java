package com.zzp.lc.controller;

import com.zzp.lc.vo.EsAppLog;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.tag-es-log}")
    private String tags;

    @RequestMapping(value = "testSendMq", method = RequestMethod.GET)
    public String testSendMq() {
        try {
            EsAppLog esAppLog = new EsAppLog();
            esAppLog.setEsIndexName("lc-log-index");
            esAppLog.setAppName("logs-center");
            esAppLog.setHost("127.0.0.1");
            esAppLog.setPort("8088");
            esAppLog.setCreateTime(new Date());

            rocketMQTemplate.convertAndSend(topic + ":" + tags, esAppLog);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
