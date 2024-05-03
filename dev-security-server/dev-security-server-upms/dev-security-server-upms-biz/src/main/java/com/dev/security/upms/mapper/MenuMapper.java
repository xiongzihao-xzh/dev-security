package com.dev.security.upms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.security.upms.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MenuMapper
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectAll();
    int deleteById(@Param("id") Long id);
}
