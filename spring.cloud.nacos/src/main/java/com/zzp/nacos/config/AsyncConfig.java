package com.zzp.nacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Description 异步方法线程池配置
 * @Author Garyzeng
 * @since 2020.12.12
 **/
@Configuration
public class AsyncConfig {

    private static final int MAX_POOL_SIZE = 50;

    private static final int CORE_POOL_SIZE = 20;

    private static final int QUEUE_CAPACITY = 100;

    @Bean("asyncTaskExecutor1")
    public AsyncTaskExecutor asyncTaskExecutor1() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-1-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }

    @Bean("asyncTaskExecutor2")
    public AsyncTaskExecutor asyncTaskExecutor2() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-2-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }
}
