package com.dev.security.tests.service;

import com.dev.security.tests.dto.PageDTO;
import com.dev.security.tests.dto.UserInfoDTO;
import com.dev.security.tests.vo.UserInfoVO;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface UserService {
    /**
     * 获取当前用户信息
     */
    UserInfoVO getOwnerUserInfo();

    /**
     * 获取用户列表
     */
    List<UserInfoVO> pageUsers(PageDTO pageDTO, UserInfoDTO userInfoDTO);

    /**
     * 添加用户
     */
    void addUser(UserInfoDTO userInfoDTO);

    /**
     * 修改用户
     */
    void updateUser(UserInfoDTO userInfoDTO);

    /**
     * 删除用户
     */
    void removeUser(long id);
}
