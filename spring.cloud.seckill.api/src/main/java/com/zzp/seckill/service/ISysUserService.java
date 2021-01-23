package com.zzp.seckill.service;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.seckill.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzp.seckill.vo.LoginUserVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zzp
 * @since 2021-01-22
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 验证登录用户，如果成功则返回token
     * @param loginUserVo 用户登录信息
     * @return String 返回token
     */
    String login(LoginUserVo loginUserVo) throws ApiException;

}
