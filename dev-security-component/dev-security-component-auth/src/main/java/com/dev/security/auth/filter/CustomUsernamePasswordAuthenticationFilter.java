package com.dev.security.auth.filter;

import com.dev.security.auth.userdetails.AuthUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author <a href="mailto:xiongzihao_xzh@163.com">xzh</a>
 * @date 2024-04-20
 */
@Slf4j
public class CustomUsernamePasswordAuthenticationFilter extends OncePerRequestFilter {

    private final SecurityContextHolderStrategy securityContextHolderStrategy =
        SecurityContextHolder.getContextHolderStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        SecurityContext securityContext = securityContextHolderStrategy.getContext();

        if (securityContext == null) {
            if (log.isDebugEnabled()) {
                log.debug("No security context found, create empty security context.");
            }
            securityContext = securityContextHolderStrategy.createEmptyContext();
            securityContextHolderStrategy.setContext(securityContext);
        }

        UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(
            "xzh",
            "secure",
            new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("sys:user:read")))
        );
        authResult.setDetails(new AuthUserDetails(1L, "xzh"));
        securityContext.setAuthentication(authResult);

        filterChain.doFilter(request, response);
    }
}
