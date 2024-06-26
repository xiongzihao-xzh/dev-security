package com.dev.security.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.security.upms.entity.Department;
import org.apache.ibatis.annotations.Param;

/**
 * DepartmentMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    int deleteById(@Param("id") Long id);
}
