package com.dev.security.upms.enums;

import com.dev.security.core.exception.ErrorCode;

/**
 * 数据重复异常
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
public enum InsertErrorCodeEnum implements ErrorCode {
    USERNAME_DUPLICATE_KEY_ERROR(110001, "用户名已存在！"),
    ROLE_DUPLICATE_KEY_ERROR(110002, "角色已存在！");

    private final int code;
    private final String message;

    InsertErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
