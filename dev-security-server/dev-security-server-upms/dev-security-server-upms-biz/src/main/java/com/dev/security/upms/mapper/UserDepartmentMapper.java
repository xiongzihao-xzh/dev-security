package com.dev.security.upms.mapper;

import com.dev.security.upms.entity.UserDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserDepartmentMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserDepartmentMapper {
    int insertList(@Param("userDepartmentList") List<UserDepartment> userDepartmentList);

    int updateDeleteFlagByUserId(@Param("updatedDeleteFlag") Integer updatedDeleteFlag, @Param("userId") Long userId);

    int updateDeleteFlagByDepartmentId(
        @Param("updatedDeleteFlag") Integer updatedDeleteFlag,
        @Param("departmentId") Long departmentId
    );
}
