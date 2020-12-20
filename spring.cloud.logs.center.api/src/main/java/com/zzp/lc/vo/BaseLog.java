package com.zzp.lc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description Base Log
 * @Author Garyzeng
 * @since 2020.12.20
 **/
public class BaseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 主机ip
     */
    private String host;

    /**
     * 端口号
     */
    private String port;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
