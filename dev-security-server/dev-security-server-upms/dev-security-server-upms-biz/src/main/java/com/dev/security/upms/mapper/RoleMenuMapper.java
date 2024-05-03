package com.dev.security.upms.mapper;

import com.dev.security.upms.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * RoleMenuMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface RoleMenuMapper {
    int insertList(@Param("roleMenuList") List<RoleMenu> roleMenuList);

    int updateDeleteFlagByRoleId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("roleId") Long roleId);

    int updateDeleteFlagByMenuId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("menuId") Long menuId);
}
