package com.dyd.ssp.smp.mapper;

import com.dyd.ssp.smp.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zwt
 * @since 2019-05-06
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findByUserId(@Param("userId")String userId);
}
