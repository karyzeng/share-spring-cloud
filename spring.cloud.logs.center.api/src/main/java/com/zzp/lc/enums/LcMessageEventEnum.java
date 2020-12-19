package com.zzp.lc.enums;

/**
 * @Description 日志中心消息事件类型枚举
 * @Author Garyzeng
 * @since 2020.12.19
 **/
public enum LcMessageEventEnum {

    LC_ES_APP_EVENT("LC_ES_APP_EVENT","esAppLogHandler", "日志中心Elasticsearch日志事件")
    ;

    private String code;

    private String classPath;

    private String description;

    private LcMessageEventEnum(String code, String classPath, String description) {
        this.code = code;
        this.classPath = classPath;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getClassPath() {
        return classPath;
    }

    public String getDescription() {
        return description;
    }

    public static String fromClassPath(String code) {
        for(LcMessageEventEnum  e : LcMessageEventEnum.values()){
            if(e.code.equals(code)) {
                return e.getClassPath();
            }
        }

        return null;

    }
}
