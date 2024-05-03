package com.dev.security.core.enums;

/**
 * 逻辑删除标记
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2023/11/20
 */
public enum DeleteFlagEnum {
    IN_USE(0),
    DELETE(1);

    private final int code;

    DeleteFlagEnum(int code) {
        this.code = code;
    }

    public int code() {
        return this.code;
    }
}
