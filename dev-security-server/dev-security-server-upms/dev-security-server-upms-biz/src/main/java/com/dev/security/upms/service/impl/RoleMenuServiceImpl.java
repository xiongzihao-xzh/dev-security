package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.upms.entity.RoleMenu;
import com.dev.security.upms.mapper.RoleMenuMapper;
import com.dev.security.upms.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色菜单业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuMapper roleMenuMapper;

    /**
     * 绑定角色和菜单
     *
     */
    @Override
    public int binding(List<RoleMenu> roleMenuList) {
        return roleMenuMapper.insertList(roleMenuList);
    }

    @Override
    public void unbindByRoleId(long roleId) {
        roleMenuMapper.updateDeleteFlagByRoleId(DeleteFlagEnum.DELETE.code(), roleId);
    }

    @Override
    public void unbindByMenuId(long menuId) {
        roleMenuMapper.updateDeleteFlagByMenuId(DeleteFlagEnum.DELETE.code(), menuId);
    }
}
