package com.dev.security.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.security.upms.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface UserMapper extends BaseMapper<User> {
    int deleteById(@Param("id") Long id);
}
