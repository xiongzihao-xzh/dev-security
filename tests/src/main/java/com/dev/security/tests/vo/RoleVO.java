package com.dev.security.tests.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-21
 */
@Getter
@Setter
public class RoleVO {

    private Long id;
    private String roleName;
    private List<String> permissions;
}
