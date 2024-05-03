package com.dev.security.upms.service.impl;

import com.dev.security.core.enums.DeleteFlagEnum;
import com.dev.security.core.util.SnowflakeIDGenerate;
import com.dev.security.upms.convert.MenuConvert;
import com.dev.security.upms.dto.MenuDTO;
import com.dev.security.upms.entity.Menu;
import com.dev.security.upms.mapper.MenuMapper;
import com.dev.security.upms.service.MenuService;
import com.dev.security.upms.service.RoleMenuService;
import com.dev.security.upms.vo.MenuTreeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 菜单业务类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-02
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuConvert menuConvert;
    private final MenuMapper menuMapper;
    private final RoleMenuService roleMenuService;

    /**
     * 新增菜单
     *
     */
    @Override
    public Menu addMenu(MenuDTO menuDTO) {
        Menu addMenu = menuConvert.toEntity(menuDTO);
        long id = SnowflakeIDGenerate.next();
        addMenu.setId(id);
        addMenu.setDeleteFlag(DeleteFlagEnum.IN_USE.code());

        menuMapper.insert(addMenu);

        return addMenu;
    }

    /**
     * 更新菜单
     *
     */
    @Override
    public Menu updateMenu(MenuDTO menuDTO) {
        Menu updateMenu = menuConvert.toEntity(menuDTO);

        menuMapper.updateById(updateMenu);

        return updateMenu;
    }

    /**
     * 删除菜单
     *
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeMenu(long menuId) {
        roleMenuService.unbindByMenuId(menuId);
        menuMapper.deleteById(menuId);
    }

    @Override
    public List<MenuTreeVO> getMenuTree() {
        List<Menu> menuList = menuMapper.selectAll();

        // TODO: 工具类重构
        if (menuList == null || menuList.isEmpty()) {
            return Collections.emptyList();
        }

        List<MenuTreeVO> menuTreeVOList = menuConvert.toMenuTreeVoList(menuList);
        Map<Long, List<MenuTreeVO>> parentIdToMenuMap = menuTreeVOList
            .stream()
            .filter(menuTreeVO -> menuTreeVO.getParentId() != null)
            .collect(Collectors.groupingBy(MenuTreeVO::getParentId));

        for (MenuTreeVO menuTreeVO : menuTreeVOList) {
            Long id = menuTreeVO.getId();
            List<MenuTreeVO> childMenuTreeVO = parentIdToMenuMap.get(id);

            if (id != null && childMenuTreeVO != null) {
                childMenuTreeVO.sort(Comparator.comparingInt(MenuTreeVO::getOrder));

                menuTreeVO.setChild(childMenuTreeVO);
            }
        }

        return menuTreeVOList.stream().filter(menuTreeVO -> menuTreeVO.getParentId() == null).toList();
    }
}
