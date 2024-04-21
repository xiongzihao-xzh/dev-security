package com.dev.security.tests.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.dev.security.tests.dao.UserDao;
import com.dev.security.tests.dao.UserRoleDao;
import com.dev.security.tests.dto.PageDTO;
import com.dev.security.tests.dto.UserInfoDTO;
import com.dev.security.tests.entity.User;
import com.dev.security.tests.entity.UserRole;
import com.dev.security.tests.service.UserService;
import com.dev.security.tests.util.SecurityContextUtil;
import com.dev.security.tests.vo.UserInfoVO;
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
// todo: 幂等校验
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;

    /**
     * 获取当前用户信息
     */
    @Override
    public UserInfoVO getOwnerUserInfo() {
        Long id = SecurityContextUtil.getId();

        if (id == null) {
            log.warn("当前用户上下文信息不存在");
            return new UserInfoVO();
        }

        UserInfoVO userInfoVO = userDao.selectUserInfoById(id);
        return userInfoVO == null ? new UserInfoVO() : userInfoVO;
    }

    /**
     * 获取用户列表
     */
    @Override
    public List<UserInfoVO> pageUsers(PageDTO pageDTO, UserInfoDTO userInfoDTO) {
        // todo: 暂时全量查询

        return userDao.listUserInfo(userInfoDTO);
    }

    /**
     * 添加用户
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addUser(UserInfoDTO userInfoDTO) {
        User user = new User();
        long userId = new Snowflake().nextId();
        user.setId(userId);
        user.setUsername(userInfoDTO.getUsername());
        user.setPassword(userInfoDTO.getPassword());
        user.setDeleteFlag(false);

        userDao.insert(user);

        List<Long> roleIds = userInfoDTO.getRoleIds();
        bindingUserRole(roleIds, userId);
    }

    /**
     * 修改用户
     */
    @Override
    public void updateUser(UserInfoDTO userInfoDTO) {
        User user = new User();
        user.setUsername(userInfoDTO.getUsername());
        user.setPassword(userInfoDTO.getPassword());

        Long userId = userInfoDTO.getId();
        userDao.updateById(user, userId);

        userRoleDao.deleteByUserId(userId);

        List<Long> roleIds = userInfoDTO.getRoleIds();
        bindingUserRole(roleIds, userId);
    }

    private void bindingUserRole(List<Long> roleIds, Long userId) {
        if (roleIds != null) {
            ArrayList<UserRole> userRoleList = new ArrayList<>(roleIds.size());
            for (Long roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRole.setDeleteFlag(false);

                userRoleList.add(userRole);
            }

            userRoleDao.insertList(userRoleList);
        }
    }

    /**
     * 删除用户
     */
    @Override
    public void removeUser(long id) {
        int deleteCount = userDao.deleteById(id);
        if (deleteCount < 1) {
            throw new RuntimeException("删除用户失败！");
        }
    }
}
