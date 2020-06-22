package com.dixonlim.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 03:49
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * @Author DixonLim
     * @Date 2020/6/22 6:19 下午
     * @Param []
     * @Return org.springframework.security.crypto.password.PasswordEncoder
     * @Description:是一个密码加密工具类，它可以实现不可逆的加密
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @Author DixonLim
     * @Date 2020/6/22 6:19 下午
     * @Param []
     * @Return org.springframework.security.authentication.AuthenticationManager
     * @Description:AuthenticationManager是为了实现 OAuth2 的 password 模式必须要指定的授权管理 Bean。
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * @Author DixonLim
     * @Date 2020/6/22 6:19 下午
     * @Param [http]
     * @Return void
     * @Description:允许匿名访问所有接口
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}
