package com.dev.security.tests.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户信息 DTO
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
@Getter
@Setter
public class UserInfoDTO {

    private Long id;
    private String username;
    private String password;
    private List<Long> roleIds;
}
