package com.dev.security.tests.dao;

import com.dev.security.tests.dto.RoleDTO;
import com.dev.security.tests.entity.Role;
import com.dev.security.tests.vo.RoleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface RoleDao {
    List<RoleVO> listRoles(@Param("condition") RoleDTO roleDTO);
    int insert(Role role);
    int updateById(@Param("updated") Role updated, @Param("id") Long id);
    int deleteById(@Param("id") Long id);
}
