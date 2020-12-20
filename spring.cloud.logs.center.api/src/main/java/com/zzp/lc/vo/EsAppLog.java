package com.zzp.lc.vo;

import java.io.Serializable;

/**
 * @Description Elasticsearch App日志信息
 * @Author Garyzeng
 * @since 2020.12.19
 **/
public class EsAppLog extends BaseLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Elasticsearch的索引名称
     */
    private String esIndexName;

    public String getEsIndexName() {
        return esIndexName;
    }

    public void setEsIndexName(String esIndexName) {
        this.esIndexName = esIndexName;
    }

}
