package com.zzp.nacos.log.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Description 公共日志实体
 * @Author karyzeng
 * @since 2020.12.14
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommonLogEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String host;

    @Field(type = FieldType.Keyword)
    private String port;

    @Field(type = FieldType.Text)
    private String appName;

    @Field(type = FieldType.Text)
    private String thread;

    @Field(type = FieldType.Keyword)
    private String level;

}
