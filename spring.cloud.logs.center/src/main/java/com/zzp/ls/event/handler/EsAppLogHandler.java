package com.zzp.ls.event.handler;

import com.alibaba.fastjson.JSON;
import com.zzp.lc.vo.EsAppLog;
import com.zzp.lc.vo.LcMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description Elasticsearch App日志信息Handler
 * @Author Garyzeng
 * @since 2020.12.19
 **/
@Component
public class EsAppLogHandler implements Handler{

    private static final Logger logger = LoggerFactory.getLogger(EsAppLogHandler.class);

    @Override
    public void handle(LcMessage lcMessage) {
        EsAppLog esAppLog = JSON.parseObject(lcMessage.getData().toString(), EsAppLog.class);
        this.eventHandle(esAppLog);
    }

    public void eventHandle(EsAppLog log) {
        logger.info("eventHandle -> 接收到的数据为：{}", JSON.toJSONString(log));
    }
}
