package com.zzp.seckill.redis;

/**
 * redis key 前缀
 */
public interface KeyPrefix {

    /**
     * 有效期
     * @return
     */
    public int expireSeconds();

    /**
     * 前缀
     * @return
     */
    public String getPrefix();
}
