package com.dev.security.upms.enums;

import com.dev.security.core.exception.ErrorCode;

/**
 * 数据库异常
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
public enum DatabaseErrorCodeEnum implements ErrorCode {
    DUPLICATE_KEY_ERROR(110001, "插入数据重复！");

    private final int code;
    private final String message;

    DatabaseErrorCodeEnum(int code, String message) {
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
