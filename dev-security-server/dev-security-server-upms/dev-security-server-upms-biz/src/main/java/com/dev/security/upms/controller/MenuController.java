package com.dev.security.upms.controller;

import com.dev.security.core.result.CommonResult;
import com.dev.security.upms.dto.MenuDTO;
import com.dev.security.upms.entity.Menu;
import com.dev.security.upms.service.MenuService;
import com.dev.security.upms.vo.MenuTreeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单控制层
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    /**
     * 添加菜单
     */
    @PostMapping
    public CommonResult addMenu(@RequestBody MenuDTO menuDTO) {
        log.info("menuDTO:{}", menuDTO);
        Menu result = menuService.addMenu(menuDTO);

        return CommonResult.success(result);
    }

    /**
     * 更新菜单
     */
    @PutMapping
    public CommonResult updateMenu(@RequestBody MenuDTO menuDTO) {
        Menu result = menuService.updateMenu(menuDTO);

        return CommonResult.success(result);
    }

    /**
     * 删除菜单
     */
    @DeleteMapping("/{id}")
    public CommonResult removeMenu(@PathVariable("id") long id) {
        menuService.removeMenu(id);

        return CommonResult.success();
    }

    /**
     * 查询菜单树
     */
    @GetMapping
    public CommonResult getMenuTree() {
        List<MenuTreeVO> result = menuService.getMenuTree();

        return CommonResult.success(result);
    }
}
