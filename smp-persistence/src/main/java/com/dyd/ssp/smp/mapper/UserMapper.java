package com.dyd.ssp.smp.mapper;

import com.dyd.ssp.smp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zwt
 * @since 2019-04-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
