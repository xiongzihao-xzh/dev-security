package com.dev.security.upms.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * UserRoleMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserRoleMapper {
    int updateDeleteFlagByUserId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("userId") Long userId);

    int updateDeleteFlagByRoleId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("roleId") Long roleId);
}
