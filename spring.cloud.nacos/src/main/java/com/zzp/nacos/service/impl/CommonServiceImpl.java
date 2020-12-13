package com.zzp.nacos.service.impl;

import com.zzp.nacos.service.ICommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description commonService接口实现类
 * @Author Garyzeng
 * @since 2020.12.12
 **/
@Service
public class CommonServiceImpl implements ICommonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async(value = "asyncTaskExecutor2")
    public void asyncTest() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        logger.info(name + "执行了异步方法");
    }
}
