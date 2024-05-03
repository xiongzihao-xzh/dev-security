package com.dev.security.upms.service;

import com.dev.security.upms.entity.RoleMenu;

import java.util.List;

/**
 * 角色菜单业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface RoleMenuService {
    /**
     * 绑定角色和菜单
     */
    int binding(List<RoleMenu> roleMenuList);
    void unbindByRoleId(long roleId);
    void unbindByMenuId(long menuId);
}
