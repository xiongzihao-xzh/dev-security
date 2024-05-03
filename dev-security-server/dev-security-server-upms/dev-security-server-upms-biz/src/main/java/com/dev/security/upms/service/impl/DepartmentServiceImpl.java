package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.core.util.SnowflakeIDGenerate;
import com.dev.security.upms.convert.DepartmentConvert;
import com.dev.security.upms.dto.DepartmentDTO;
import com.dev.security.upms.entity.Department;
import com.dev.security.upms.mapper.DepartmentMapper;
import com.dev.security.upms.service.DepartmentService;
import com.dev.security.upms.service.UserDepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentConvert departmentConvert;
    private final DepartmentMapper departmentMapper;
    private final UserDepartmentService userDepartmentService;

    @Override
    public Department addDepartment(DepartmentDTO departmentDTO) {
        Department addDept = departmentConvert.toEntity(departmentDTO);

        long id = SnowflakeIDGenerate.next();
        addDept.setId(id);
        addDept.setDeleteFlag(DeleteFlagEnum.IN_USE.code());

        departmentMapper.insert(addDept);

        return addDept;
    }

    @Override
    public Department updateDepartment(DepartmentDTO departmentDTO) {
        Department updateDept = departmentConvert.toEntity(departmentDTO);

        departmentMapper.insert(updateDept);

        return updateDept;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeDepartment(long departmentId) {
        userDepartmentService.unbindByDepartmentId(departmentId);
        departmentMapper.deleteById(departmentId);
    }
}
