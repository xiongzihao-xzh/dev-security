package com.dev.security.upms.controller;

import com.dev.security.core.result.CommonResult;
import com.dev.security.upms.dto.UserDTO;
import com.dev.security.upms.entity.User;
import com.dev.security.upms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-04
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 添加用户
     */
    @PostMapping
    public CommonResult addUser(UserDTO userDTO) {
        User result = userService.addUser(userDTO);

        return CommonResult.success(result);
    }

    /**
     * 更新用户
     */
    @PutMapping
    public CommonResult updateUser(UserDTO userDTO) {
        User result = userService.updateUser(userDTO);

        return CommonResult.success(result);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public CommonResult removeUser(@PathVariable long id) {
        userService.removeUser(id);

        return CommonResult.success();
    }
}
