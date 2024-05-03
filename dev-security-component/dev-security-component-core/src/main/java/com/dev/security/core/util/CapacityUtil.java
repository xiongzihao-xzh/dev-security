package com.dev.security.core.util;

/**
 * CapacityUtil
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-05-03
 */
public class CapacityUtil {

    private CapacityUtil() {}

    public static int getCapacity(int size) {
        return (int) Math.max((size / 0.75) + 1, 16);
    }
}
