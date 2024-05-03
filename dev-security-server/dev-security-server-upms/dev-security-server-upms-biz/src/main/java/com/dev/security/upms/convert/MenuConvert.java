package com.dev.security.upms.convert;

import com.dev.security.upms.dto.MenuDTO;
import com.dev.security.upms.entity.Menu;
import com.dev.security.upms.vo.MenuTreeVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

/**
 * MenuConvert
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MenuConvert {
    Menu toEntity(MenuDTO menuDTO);

    MenuDTO toDTO(Menu menu);

    List<MenuTreeVO> toMenuTreeVoList(List<Menu> menuList);
}
