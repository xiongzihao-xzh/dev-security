package com.dev.security.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.security.upms.entity.Role;
import org.apache.ibatis.annotations.Param;

/**
 * RoleMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface RoleMapper extends BaseMapper<Role> {
    int deleteById(@Param("id") Long id);
}
