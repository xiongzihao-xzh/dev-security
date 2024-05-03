package com.dev.security.upms.convert;

import com.dev.security.upms.dto.DepartmentDTO;
import com.dev.security.upms.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * DepartmentConvert
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-04
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentConvert {
    Department toEntity(DepartmentDTO departmentDTO);

    DepartmentDTO toDTO(Department department);
}
