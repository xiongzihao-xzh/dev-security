package com.dev.security.upms.service;

import com.dev.security.upms.dto.RoleDTO;
import com.dev.security.upms.entity.Role;

/**
 * 角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface RoleService {
    /**
     * 添加角色
     */
    Role addRole(RoleDTO roleDTO);
    /**
     * 更新角色
     */
    Role updateRole(RoleDTO roleDTO);
    /**
     * 删除角色
     */
    void deleteRole(long roleId);
}
