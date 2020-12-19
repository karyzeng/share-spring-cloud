package com.zzp.lc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description Elasticsearch App日志信息
 * @Author Garyzeng
 * @since 2020.12.19
 **/
public class EsAppLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Elasticsearch的索引名称
     */
    private String esIndexName;

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

    public String getEsIndexName() {
        return esIndexName;
    }

    public void setEsIndexName(String esIndexName) {
        this.esIndexName = esIndexName;
    }

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
