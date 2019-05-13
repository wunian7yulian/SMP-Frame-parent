package com.dyd.ssp.smp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dyd.ssp.smp.entity.Permission;
import com.dyd.ssp.smp.mapper.PermissionMapper;
import com.dyd.ssp.smp.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwt
 * @since 2019-05-06
 */
@Service
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {


    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findByTypeAndStatusOrderBySortOrder(Integer type, Integer status) {

        LambdaQueryWrapper<Permission> permissionLambdaQueryWrapper = new QueryWrapper<Permission>().lambda().eq(Permission::getType, type).eq(Permission::getStatus, status).orderByAsc(Permission::getSortOrder);
        return permissionMapper.selectList(permissionLambdaQueryWrapper);
    }

}
