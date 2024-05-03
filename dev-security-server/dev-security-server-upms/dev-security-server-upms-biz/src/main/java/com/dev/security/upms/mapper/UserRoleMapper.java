package com.dev.security.upms.mapper;

import com.dev.security.upms.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserRoleMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserRoleMapper {
    int insertList(@Param("userRoleList") List<UserRole> userRoleList);

    int updateDeleteFlagByUserId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("userId") Long userId);

    int updateDeleteFlagByRoleId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("roleId") Long roleId);
}
