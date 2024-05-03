package com.dev.security.upms.service;

import com.dev.security.upms.entity.UserRole;

import java.util.List;

/**
 * 用户角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserRoleService {
    void binding(List<UserRole> userRoleList);
    void unbindByUserId(long userId);
    void unbindByRoleId(long roleId);
}
