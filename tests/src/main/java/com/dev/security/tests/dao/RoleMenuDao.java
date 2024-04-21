package com.dev.security.tests.dao;

import com.dev.security.tests.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface RoleMenuDao {
    int insertList(@Param("roleMenuList") List<RoleMenu> roleMenuList);

    int deleteByRoleId(@Param("roleId") Long roleId);

    int deleteByMenuId(@Param("menuId") Long menuId);
}
