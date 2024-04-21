package com.dev.security.tests.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.dev.security.tests.dao.RoleDao;
import com.dev.security.tests.dao.RoleMenuDao;
import com.dev.security.tests.dao.UserRoleDao;
import com.dev.security.tests.dto.PageDTO;
import com.dev.security.tests.dto.RoleDTO;
import com.dev.security.tests.entity.Role;
import com.dev.security.tests.entity.RoleMenu;
import com.dev.security.tests.service.RoleService;
import com.dev.security.tests.vo.RoleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final UserRoleDao userRoleDao;
    private final RoleMenuDao roleMenuDao;

    /**
     * 分页查询角色
     *
     */
    @Override
    public List<RoleVO> pageRoles(PageDTO pageDTO, RoleDTO roleDTO) {
        return roleDao.listRoles(roleDTO);
    }

    /**
     * 添加角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRole(RoleDTO roleDTO) {
        Role role = new Role();
        long roleId = new Snowflake().nextId();
        role.setId(roleId);
        role.setRoleName(roleDTO.getRoleName());
        roleDao.insert(role);

        List<Long> permissionIds = roleDTO.getPermissionIds();
        bindingRoleMenu(permissionIds, roleId);
    }

    /**
     * 更新角色
     *
     */
    @Override
    public void updateRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());

        Long roleId = roleDTO.getId();
        roleDao.updateById(role, roleId);

        roleMenuDao.deleteByRoleId(roleId);

        List<Long> permissionIds = roleDTO.getPermissionIds();
        bindingRoleMenu(permissionIds, roleId);
    }

    private void bindingRoleMenu(List<Long> permissionIds, Long roleId) {
        if (permissionIds != null) {
            ArrayList<RoleMenu> roleMenuList = new ArrayList<>(permissionIds.size());
            for (Long permissionId : permissionIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(permissionId);
                roleMenu.setDeleteFlag(false);

                roleMenuList.add(roleMenu);
            }

            roleMenuDao.insertList(roleMenuList);
        }
    }

    /**
     * 删除角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(long roleId) {
        userRoleDao.deleteByRoleId(roleId);
        roleMenuDao.deleteByRoleId(roleId);
        roleDao.deleteById(roleId);
    }
}
