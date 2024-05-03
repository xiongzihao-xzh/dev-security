package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.upms.entity.UserDepartment;
import com.dev.security.upms.mapper.UserDepartmentMapper;
import com.dev.security.upms.service.UserDepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户部门业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class UserDepartmentServiceImpl implements UserDepartmentService {

    private final UserDepartmentMapper userDepartmentMapper;

    @Override
    public void binding(List<UserDepartment> userDepartmentList) {
        userDepartmentMapper.insertList(userDepartmentList);
    }

    @Override
    public void unbindByUserId(long userId) {
        userDepartmentMapper.updateDeleteFlagByUserId(DeleteFlagEnum.DELETE.code(), userId);
    }

    @Override
    public void unbindByDepartmentId(long departmentId) {
        userDepartmentMapper.updateDeleteFlagByDepartmentId(DeleteFlagEnum.DELETE.code(), departmentId);
    }
}
