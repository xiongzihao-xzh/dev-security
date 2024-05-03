package com.dev.security.upms.service;

/**
 * 用户角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserRoleService {
    void removeByRoleId(long roleId);
    void removeByUserId(long menuId);
}
