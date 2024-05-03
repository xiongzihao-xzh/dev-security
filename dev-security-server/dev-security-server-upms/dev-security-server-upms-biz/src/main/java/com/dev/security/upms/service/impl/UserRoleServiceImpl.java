package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.upms.entity.UserRole;
import com.dev.security.upms.mapper.UserRoleMapper;
import com.dev.security.upms.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void binding(List<UserRole> userRoleList) {
        userRoleMapper.insertList(userRoleList);
    }

    @Override
    public void unbindByUserId(long userId) {
        userRoleMapper.updateDeleteFlagByUserId(DeleteFlagEnum.DELETE.code(), userId);
    }

    @Override
    public void unbindByRoleId(long roleId) {
        userRoleMapper.updateDeleteFlagByRoleId(DeleteFlagEnum.DELETE.code(), roleId);
    }
}
