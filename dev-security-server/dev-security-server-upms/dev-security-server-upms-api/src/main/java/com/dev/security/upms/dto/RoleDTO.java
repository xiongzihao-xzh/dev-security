package com.dev.security.upms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * RoleDTO
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long roleId;
    private List<Long> menuIdList;
}
