package com.dyd.ssp.smp.service;

import com.dyd.ssp.smp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwt
 * @since 2019-05-06
 */
@CacheConfig(cacheNames = "user")
public interface IUserService extends IService<User> {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    @Cacheable(key = "#username")
    User findByUsername(String username);

}
