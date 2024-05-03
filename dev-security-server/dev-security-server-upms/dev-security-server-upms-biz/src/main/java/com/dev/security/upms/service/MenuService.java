package com.dev.security.upms.service;

import com.dev.security.upms.dto.MenuDTO;
import com.dev.security.upms.entity.Menu;
import com.dev.security.upms.vo.MenuTreeVO;

import java.util.List;

/**
 * 菜单业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
public interface MenuService {
    /**
     * 新增菜单
     */
    Menu addMenu(MenuDTO menuDTO);

    /**
     * 更新菜单
     */
    Menu updateMenu(MenuDTO menuDTO);

    /**
     * 删除菜单
     */
    void removeMenu(long menuId);

    List<MenuTreeVO> getMenuTree();
}
