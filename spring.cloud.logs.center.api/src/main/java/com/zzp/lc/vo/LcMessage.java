package com.zzp.lc.vo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Description 日志中心消息Vo
 * @Author Garyzeng
 * @since 2020.12.19
 **/
public class LcMessage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事件类型
     */
    private String event;

    /**
     * 数据内容
     */
    private T data;

    public LcMessage() {}

    public LcMessage(String event, T data) {
        this.event = event;
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if (this == null) {
            return null;
        }

        return JSON.toJSONString(this);
    }
}
