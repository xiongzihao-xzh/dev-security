package com.dev.security.tests.service;

import com.dev.security.tests.dto.PageDTO;
import com.dev.security.tests.dto.RoleDTO;
import com.dev.security.tests.vo.RoleVO;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface RoleService {
    /**
     * 分页查询角色
     */
    List<RoleVO> pageRoles(PageDTO pageDTO, RoleDTO roleDTO);

    /**
     * 添加角色
     */
    void addRole(RoleDTO roleDTO);

    /**
     * 更新角色
     */
    void updateRole(RoleDTO roleDTO);

    /**
     * 删除角色
     */
    void deleteRole(long roleId);
}
