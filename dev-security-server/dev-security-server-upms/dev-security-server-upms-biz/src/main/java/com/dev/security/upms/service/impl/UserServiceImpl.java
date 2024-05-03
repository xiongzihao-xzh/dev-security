package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.core.exception.ServiceException;
import com.dev.security.core.util.CapacityUtil;
import com.dev.security.core.util.SnowflakeIDGenerate;
import com.dev.security.upms.convert.UserConvert;
import com.dev.security.upms.dto.UserDTO;
import com.dev.security.upms.entity.User;
import com.dev.security.upms.entity.UserDepartment;
import com.dev.security.upms.entity.UserRole;
import com.dev.security.upms.enums.InsertErrorCodeEnum;
import com.dev.security.upms.mapper.UserMapper;
import com.dev.security.upms.service.UserDepartmentService;
import com.dev.security.upms.service.UserRoleService;
import com.dev.security.upms.service.UserService;
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
public class UserServiceImpl implements UserService {

    private final UserConvert userConvert;
    private final UserMapper userMapper;
    private final UserRoleService userRoleService;
    private final UserDepartmentService userDepartmentService;

    /**
     * 添加用户
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User addUser(UserDTO userDTO) {
        User addUser = userConvert.toEntity(userDTO);

        long userId = SnowflakeIDGenerate.next();
        addUser.setId(userId);
        addUser.setDeleteFlag(DeleteFlagEnum.IN_USE.code());
        try {
            userMapper.insert(addUser);
        } catch (DuplicateKeyException e) {
            throw new ServiceException(InsertErrorCodeEnum.USERNAME_DUPLICATE_KEY_ERROR);
        }

        List<Long> roleIdList = userDTO.getRoleIdList();
        bindingUserRole(roleIdList, userId);

        List<Long> departmentIdList = userDTO.getDepartmentIdList();
        bindingUserDepartment(departmentIdList, userId);

        return addUser;
    }

    /**
     * 更新用户
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User updateUser(UserDTO userDTO) {
        User updateUser = userConvert.toEntity(userDTO);

        try {
            userMapper.updateById(updateUser);
        } catch (DuplicateKeyException e) {
            throw new ServiceException(InsertErrorCodeEnum.USERNAME_DUPLICATE_KEY_ERROR);
        }

        Long userId = userDTO.getId();

        userRoleService.unbindByUserId(userId);
        List<Long> roleIdList = userDTO.getRoleIdList();
        bindingUserRole(roleIdList, userId);

        userDepartmentService.unbindByUserId(userId);
        List<Long> departmentIdList = userDTO.getDepartmentIdList();
        bindingUserDepartment(departmentIdList, userId);

        return updateUser;
    }

    private void bindingUserRole(List<Long> roleIdList, long userId) {
        if (roleIdList != null && !roleIdList.isEmpty()) {
            List<UserRole> userRoleList = new ArrayList<>(CapacityUtil.getCapacity(roleIdList.size()));

            for (Long roleId : roleIdList) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRole.setDeleteFlag(DeleteFlagEnum.IN_USE.code());

                userRoleList.add(userRole);
            }

            userRoleService.binding(userRoleList);
        }
    }

    private void bindingUserDepartment(List<Long> departmentIdList, long userId) {
        if (departmentIdList != null && !departmentIdList.isEmpty()) {
            List<UserDepartment> userDepartmentList = new ArrayList<>(
                CapacityUtil.getCapacity(departmentIdList.size())
            );

            for (Long departmentId : departmentIdList) {
                UserDepartment userDepartment = new UserDepartment();
                userDepartment.setUserId(userId);
                userDepartment.setDepartmentId(departmentId);
                userDepartment.setDeleteFlag(DeleteFlagEnum.IN_USE.code());

                userDepartmentList.add(userDepartment);
            }

            userDepartmentService.binding(userDepartmentList);
        }
    }

    /**
     * 删除用户
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeUser(long userId) {
        userRoleService.unbindByUserId(userId);
        userDepartmentService.unbindByUserId(userId);
        userMapper.deleteById(userId);
    }
}
