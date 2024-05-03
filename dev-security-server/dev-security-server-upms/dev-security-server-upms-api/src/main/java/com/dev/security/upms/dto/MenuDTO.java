package com.dev.security.upms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MenuDTO
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private Long id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 顺序
     */
    private Integer order;

    /**
     * 父菜单 id
     */
    private Long parentId;
}
