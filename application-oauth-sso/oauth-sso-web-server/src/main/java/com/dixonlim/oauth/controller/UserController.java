package com.dixonlim.oauth.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 22:31
 * @Description:
 */
@Slf4j
@RestController
public class UserController {

    @GetMapping(value = "get")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get(Authentication authentication){
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }

    @GetMapping(value = "jwt")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object jwtParser(Authentication authentication){
        authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
        String jwtToken = details.getTokenValue();
        Claims claims = Jwts.parser()
                .setSigningKey("dev".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }
}
