package com.dev.security.upms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 菜单树 VO
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuTreeVO {

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

    /**
     * 子菜单
     */
    private List<MenuTreeVO> child;
}
