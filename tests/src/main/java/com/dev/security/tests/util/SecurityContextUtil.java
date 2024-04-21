package com.dev.security.tests.util;

import com.dev.security.auth.userdetails.AuthUserDetails;
import lombok.Getter;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-21
 */
@Getter
public class SecurityContextUtil {

    private SecurityContextUtil() {}

    public static Long getId() {
        AuthUserDetails details = getDetails();

        return details.getId();
    }

    public static String getUsername() {
        AuthUserDetails details = getDetails();

        return details.getUsername();
    }

    private static AuthUserDetails getDetails() {
        AuthUserDetails details = (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details == null) {
            throw new RuntimeException("current user details is null.");
        }
        return details;
    }
}
