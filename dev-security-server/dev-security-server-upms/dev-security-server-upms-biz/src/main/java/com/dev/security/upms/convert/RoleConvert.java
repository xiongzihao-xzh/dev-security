package com.dev.security.upms.convert;

import com.dev.security.upms.dto.RoleDTO;
import com.dev.security.upms.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * RoleConvert
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleConvert {
    Role toEntity(RoleDTO roleDTO);

    RoleDTO toDTO(Role role);
}
