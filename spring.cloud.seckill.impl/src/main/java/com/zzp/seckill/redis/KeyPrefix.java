package com.zzp.seckill.redis;

/**
 * redis key前缀
 * @author zzp
 * @since 2021.01.23
 */
public interface KeyPrefix {

    /**
     * 有效期
     * @return
     */
    int expireSeconds();

    /**
     * 前缀
     * @return
     */
    String getPrefix();
}
