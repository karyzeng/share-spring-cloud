package com.zzp.nacos.user.service.impl;

import com.zzp.nacos.user.entity.User;
import com.zzp.nacos.user.mapper.UserMapper;
import com.zzp.nacos.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2020-09-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
