package com.dev.security.upms.service;

/**
 * 角色菜单业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface RoleMenuService {
    void removeByRoleId(long roleId);
    void removeByMenuId(long menuId);
}
