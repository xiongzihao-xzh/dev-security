package com.dev.security.upms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DepartmentDTO
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    /**
     * 部门名字
     */
    private String name;

    /**
     * 顺序
     */
    private Integer order;

    /**
     * 上级部门 id
     */
    private Long parentId;
}
