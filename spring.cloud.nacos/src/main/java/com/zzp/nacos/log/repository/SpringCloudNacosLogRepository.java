package com.zzp.nacos.log.repository;

import com.zzp.nacos.log.entity.SpringCloudNacosLogEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * SpringCloudNacosLogRepository
 */
public interface SpringCloudNacosLogRepository extends ElasticsearchRepository<SpringCloudNacosLogEntity, String> {


}
