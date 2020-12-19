package com.zzp.ls.event.handler;

import com.zzp.lc.vo.LcMessage;

/**
 * @Description 日志中心消息处理Handler接口
 * @Author Garyzeng
 * @since 2020.12.19
 **/
public interface Handler {

    /**
     * 处理消息接口
     * @param lcMessage
     */
    void handle(LcMessage lcMessage);

}
