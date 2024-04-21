package com.dev.security.tests.dao;

import com.dev.security.tests.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface UserRoleDao {
    int insertList(@Param("userRoleList") List<UserRole> userRoleList);

    int deleteByUserId(@Param("userId") Long userId);

    int deleteByRoleId(@Param("roleId") Long roleId);
}
