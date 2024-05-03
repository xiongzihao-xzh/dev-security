package com.dev.security.upms.service;

import com.dev.security.upms.dto.UserDTO;
import com.dev.security.upms.entity.User;

/**
 * 角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserService {
    /**
     * 添加用户
     */
    User addUser(UserDTO userDTO);

    /**
     * 更新用户
     */
    User updateUser(UserDTO userDTO);

    /**
     * 删除用户
     */
    void removeUser(long userId);
}
