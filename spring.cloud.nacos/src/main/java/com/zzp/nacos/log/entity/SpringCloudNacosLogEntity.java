package com.zzp.nacos.log.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Description SpringCloudNacos日志实体
 * @Author karyzeng
 * @since 2020.12.14
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Document(indexName = "#{logIndexConfig.springCloudNacosIndex}", createIndex = false)
public class SpringCloudNacosLogEntity extends CommonLogEntity{

    private static final long serialVersionUID = -1L;

    @Field(type = FieldType.Text)
    private String message;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private Date createTime;

}
