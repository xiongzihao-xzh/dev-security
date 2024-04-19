package com.dev.security.auth.config;

import com.dev.security.auth.filter.CustomUsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类
 *
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // 关闭不用的过滤器
        http
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .rememberMe(AbstractHttpConfigurer::disable)
            .logout(AbstractHttpConfigurer::disable)
            .sessionManagement(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .requestCache(AbstractHttpConfigurer::disable)
            .headers(headers -> headers.cacheControl(HeadersConfigurer.CacheControlConfig::disable));

        http
            .authorizeHttpRequests(authorizeHttpRequests -> {
                authorizeHttpRequests.anyRequest().authenticated();
            })
            .addFilterBefore(
                new CustomUsernamePasswordAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class
            );
        
        // TODO: 
        //     - 配置 login 认证成功处理器和失败处理器
        //     - 配置 ExceptionTranslationFilter

        return http.build();
    }
}
