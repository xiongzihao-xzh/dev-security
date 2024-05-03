package com.dev.security.upms.controller;

import com.dev.security.core.result.CommonResult;
import com.dev.security.upms.dto.DepartmentDTO;
import com.dev.security.upms.entity.Department;
import com.dev.security.upms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 部门控制层
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-04
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private final DepartmentService departmentService;
    
    /**
     * 添加部门
     */
    @PostMapping
    public CommonResult addDepartment(DepartmentDTO departmentDTO) {
        Department result = departmentService.addDepartment(departmentDTO);
        
        return CommonResult.success(result);
    }
    /**
     * 更新部门
     */
    @PutMapping
    public CommonResult updateDepartment(DepartmentDTO departmentDTO) {
        Department result = departmentService.updateDepartment(departmentDTO);
        
        return CommonResult.success(result);
    }
    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public CommonResult removeDepartment(@PathVariable long id) {
        departmentService.removeDepartment(id);
        
        return CommonResult.success();
    }
}
