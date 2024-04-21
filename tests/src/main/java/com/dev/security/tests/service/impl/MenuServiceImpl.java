package com.dev.security.tests.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.dev.security.tests.dao.MenuDao;
import com.dev.security.tests.dao.RoleMenuDao;
import com.dev.security.tests.dto.MenuDTO;
import com.dev.security.tests.entity.Menu;
import com.dev.security.tests.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuDao menuDao;
    private final RoleMenuDao roleMenuDao;

    @Override
    public void addMenu(MenuDTO menuDTO) {
        long menuId = new Snowflake().nextId();
        Menu menu = new Menu();
        menu.setId(menuId);
        menu.setMenuName(menuDTO.getMenuName());
        menu.setParentId(menuDTO.getParentId());
        menu.setPermission(menuDTO.getPermission());

        menuDao.insert(menu);
    }

    @Override
    public void updateMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        menu.setMenuName(menuDTO.getMenuName());
        menu.setParentId(menuDTO.getParentId());
        menu.setPermission(menuDTO.getPermission());

        Long id = menuDTO.getId();
        menuDao.updateById(menu, id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteMenu(long menuId) {
        menuDao.deleteById(menuId);
        roleMenuDao.deleteByMenuId(menuId);
    }
}
