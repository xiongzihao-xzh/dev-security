package com.dev.security.tests.dao;

import com.dev.security.tests.entity.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface MenuDao {
    int insert(Menu menu);
    int updateById(@Param("updated") Menu updated, @Param("id") Long id);
    int deleteById(@Param("id") Long id);
}
