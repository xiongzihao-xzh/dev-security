package com.dev.security.upms.service;

import com.dev.security.upms.entity.UserDepartment;

import java.util.List;

/**
 * 用户部门业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserDepartmentService {
    void binding(List<UserDepartment> userDepartmentList);
    void unbindByUserId(long userId);
    void unbindByDepartmentId(long departmentId);
}
