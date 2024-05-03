package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.core.exception.ServiceException;
import com.dev.security.core.util.CapacityUtil;
import com.dev.security.core.util.SnowflakeIDGenerate;
import com.dev.security.upms.convert.RoleConvert;
import com.dev.security.upms.dto.RoleDTO;
import com.dev.security.upms.entity.Role;
import com.dev.security.upms.entity.RoleMenu;
import com.dev.security.upms.enums.InsertErrorCodeEnum;
import com.dev.security.upms.mapper.RoleMapper;
import com.dev.security.upms.service.RoleMenuService;
import com.dev.security.upms.service.RoleService;
import com.dev.security.upms.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleConvert roleConvert;
    private final RoleMapper roleMapper;
    private final RoleMenuService roleMenuService;
    private final UserRoleService userRoleService;

    /**
     * 添加角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Role addRole(RoleDTO roleDTO) {
        Role addRole = roleConvert.toEntity(roleDTO);

        long roleId = SnowflakeIDGenerate.next();
        addRole.setId(roleId);
        addRole.setDeleteFlag(DeleteFlagEnum.IN_USE.code());
        try {
            roleMapper.insert(addRole);
        } catch (DuplicateKeyException e) {
            throw new ServiceException(InsertErrorCodeEnum.ROLE_DUPLICATE_KEY_ERROR);
        }

        List<Long> menuIdList = roleDTO.getMenuIdList();
        bindingRoleMenu(menuIdList, roleId);

        return addRole;
    }

    /**
     * 更新角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Role updateRole(RoleDTO roleDTO) {
        // todo: 责任链校验参数

        Role updateRole = roleConvert.toEntity(roleDTO);

        try {
            roleMapper.updateById(updateRole);
        } catch (DuplicateKeyException e) {
            throw new ServiceException(InsertErrorCodeEnum.ROLE_DUPLICATE_KEY_ERROR);
        }

        Long roleId = roleDTO.getRoleId();
        roleMenuService.unbindByRoleId(roleId);
        List<Long> menuIdList = roleDTO.getMenuIdList();
        bindingRoleMenu(menuIdList, roleId);

        return updateRole;
    }

    /**
     * 绑定角色和菜单
     */
    private void bindingRoleMenu(List<Long> menuIdList, long roleId) {
        // todo
        if (menuIdList != null && !menuIdList.isEmpty()) {
            List<RoleMenu> roleMenuList = new ArrayList<>(CapacityUtil.getCapacity(menuIdList.size()));
            for (Long menuId : menuIdList) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenu.setDeleteFlag(DeleteFlagEnum.IN_USE.code());

                roleMenuList.add(roleMenu);
            }

            roleMenuService.binding(roleMenuList);
        }
    }

    /**
     * 删除角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(long roleId) {
        userRoleService.unbindByRoleId(roleId);
        roleMenuService.unbindByRoleId(roleId);
        roleMapper.deleteById(roleId);
    }
}
