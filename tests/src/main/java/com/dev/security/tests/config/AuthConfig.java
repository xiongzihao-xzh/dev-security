package com.dev.security.tests.config;

import com.dev.security.auth.userdetails.UserDetailsRepository;
import com.dev.security.tests.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-21
 */
@RequiredArgsConstructor
@Configuration
public class AuthConfig {

    private final UserDao userDao;

    /**
     * 通过依赖倒置注入数据源
     * @return
     */
    @Bean
    public UserDetailsRepository mysqlUserDetailsRepository() {
        return new UserDetailsRepository() {};
    }
}
