package com.zzp.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.seckill.entity.SysUser;
import com.zzp.seckill.mapper.SysUserMapper;
import com.zzp.seckill.redis.RedisService;
import com.zzp.seckill.redis.UserKey;
import com.zzp.seckill.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzp.seckill.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2021-01-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private RedisService redisService;

    @Override
    public String login(LoginUserVo loginUserVo) throws ApiException {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<SysUser>();
        queryWrapper.eq(SysUser::getLoginId, loginUserVo.getLoginId());
        queryWrapper.eq(SysUser::getPassword, loginUserVo.getPassword());

        SysUser sysUser = this.getOne(queryWrapper);

        if (sysUser == null) {
            throw new ApiException("用户不存在！");
        }

        // 生成token
        String token = UUID.randomUUID().toString().replace("-", "");
        // 将token作为key，sysUser作为value存入redis
        redisService.set(UserKey.token, token, sysUser);

        return token;
    }
}
