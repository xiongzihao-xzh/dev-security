package com.dev.security.upms.service.impl;

import com.dev.security.upms.mapper.UserRoleMapper;
import com.dev.security.upms.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Override
    public void removeByRoleId(long roleId) {}

    @Override
    public void removeByUserId(long userId) {}
}
