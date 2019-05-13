package com.dyd.ssp.smp.mapper;

import com.dyd.ssp.smp.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zwt
 * @since 2019-05-06
 */
public interface PermissionMapper extends BaseMapper<Permission> {


    List<Permission> findByUserId(String id);
}
