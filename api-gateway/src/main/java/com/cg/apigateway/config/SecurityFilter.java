package com.cg.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Component
public class SecurityFilter implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String requiredRole = exchange.getAttribute("roles");

        if (authentication != null && hasRequiredRole(authentication, requiredRole)) {
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }
	}
	 private boolean hasRequiredRole(Authentication authentication, String requiredRole) {
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        return authorities.stream().anyMatch(authority -> authority.getAuthority().equals(requiredRole));
	    }

}
