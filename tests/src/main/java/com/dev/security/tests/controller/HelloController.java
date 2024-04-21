package com.dev.security.tests.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-18
 */
@Slf4j
@RestController
@EnableMethodSecurity
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('sys:user:read')")
    public String hello() {
        log.info("Hello World, {}", SecurityContextHolder.getContext().getAuthentication());

        return "Hello World, " + SecurityContextHolder.getContext().getAuthentication();
    }
}
