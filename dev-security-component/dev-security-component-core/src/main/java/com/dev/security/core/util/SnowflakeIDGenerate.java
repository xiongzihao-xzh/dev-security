package com.dev.security.core.util;

/**
 * 生成雪花算法
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
public class SnowflakeIDGenerate {

    private SnowflakeIDGenerate() {}

    public static long next() {
        // TODO: 引入雪花算法
        return System.currentTimeMillis();
    }
}
