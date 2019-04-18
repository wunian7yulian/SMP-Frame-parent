package com.dyd.ssp.smp.service.impl;

import com.dyd.ssp.smp.entity.User;
import com.dyd.ssp.smp.mapper.UserMapper;
import com.dyd.ssp.smp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zwt
 * @since 2019-04-18
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
