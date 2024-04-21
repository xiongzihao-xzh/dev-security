package com.dev.security.tests.dao;

import com.dev.security.tests.dto.UserInfoDTO;
import com.dev.security.tests.entity.User;
import com.dev.security.tests.vo.UserInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface UserDao {
    User selectById(@Param("id") Long id);
    User selectByUsername(@Param("username") String username);
    UserInfoVO selectUserInfoById(@Param("id") Long id);
    List<UserInfoVO> listUserInfo(@Param("condition") UserInfoDTO userInfoDTO);
    int insert(User user);
    int updateById(@Param("updated") User updated, @Param("id") Long id);
    int deleteById(@Param("id") Long id);
}
