package com.dev.security.upms.controller;

import com.dev.security.core.result.CommonResult;
import com.dev.security.upms.dto.RoleDTO;
import com.dev.security.upms.entity.Role;
import com.dev.security.upms.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制层
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    /**
     * 添加角色
     */
    @PostMapping
    public CommonResult addRole(@RequestBody RoleDTO roleDTO) {
        Role result = roleService.addRole(roleDTO);

        return CommonResult.success(result);
    }

    /**
     * 更新角色
     */
    @PutMapping
    public CommonResult updateRole(@RequestBody RoleDTO roleDTO) {
        Role result = roleService.updateRole(roleDTO);

        return CommonResult.success(result);
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{id}")
    public CommonResult removeRole(@PathVariable long id) {
        roleService.deleteRole(id);

        return CommonResult.success();
    }
}
