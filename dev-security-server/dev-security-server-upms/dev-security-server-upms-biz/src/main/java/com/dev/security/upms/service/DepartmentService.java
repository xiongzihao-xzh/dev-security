package com.dev.security.upms.service;

import com.dev.security.upms.dto.DepartmentDTO;
import com.dev.security.upms.entity.Department;

/**
 * 部门业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface DepartmentService {
    // 添加部门
    Department addDepartment(DepartmentDTO departmentDTO);
    // 更新部门
    Department updateDepartment(DepartmentDTO departmentDTO);
    // 删除部门
    void removeDepartment(long departmentId);
}
