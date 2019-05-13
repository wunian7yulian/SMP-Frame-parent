package com.dyd.ssp.smp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dyd.ssp.smp.entity.Permission;
import com.dyd.ssp.smp.entity.Role;
import com.dyd.ssp.smp.entity.User;
import com.dyd.ssp.smp.mapper.PermissionMapper;
import com.dyd.ssp.smp.mapper.RoleMapper;
import com.dyd.ssp.smp.mapper.UserMapper;
import com.dyd.ssp.smp.service.IUserService;
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
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByUsername(String username) {
        List<User> list = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
        if(list!=null&&list.size()>0){
            User user = list.get(0);
            // 关联角色
            List<Role> roleList = roleMapper.findByUserId(user.getId());
            user.setRoles(roleList);
            // 关联权限菜单
            List<Permission> permissionList = permissionMapper.findByUserId(user.getId());
            user.setPermissions(permissionList);
            return user;
        }
        return null;
    }
}
