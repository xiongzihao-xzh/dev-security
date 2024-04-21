package com.dev.security.tests.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-21
 */
@Getter
@Setter
public class MenuDTO {

    private Long id;
    private String menuName;
    private Long parentId;
    private String permission;
}
