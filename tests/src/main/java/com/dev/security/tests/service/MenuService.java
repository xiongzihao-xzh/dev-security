package com.dev.security.tests.service;

import com.dev.security.tests.dto.MenuDTO;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
public interface MenuService {
    void addMenu(MenuDTO menuDTO);
    void updateMenu(MenuDTO menuDTO);
    void deleteMenu(long menuId);
}
