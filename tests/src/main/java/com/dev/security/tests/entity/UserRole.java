package com.dev.security.tests.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户角色关联表
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
@Data
public class UserRole {

    private Long userId;

    private Long roleId;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

    private Boolean deleteFlag;
}
