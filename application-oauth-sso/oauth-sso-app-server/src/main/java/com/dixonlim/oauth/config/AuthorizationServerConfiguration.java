package com.dixonlim.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 03:40
 * @Description:
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService securityUserDetailsService;
//    @Autowired
//    private TokenStore redisTokenStore;
    @Autowired
    private TokenStore jwtTokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    /**
     * @Author DixonLim
     * @Date 2020/6/22 6:26 下午
     * @Param [clients]
     * @Return void
     * @Description: 以数据库的数据配置授权方式
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcClientDetailsServiceBuilder jdbc = clients.jdbc(dataSource);
        jdbc.passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        TokenEnhancerChain	enhancerChain	= new TokenEnhancerChain();
        List<TokenEnhancer> enhancerList	= new ArrayList<>();
        enhancerList.add( jwtTokenEnhancer );
        enhancerList.add( jwtAccessTokenConverter );
        enhancerChain.setTokenEnhancers( enhancerList );
        endpoints.authenticationManager(authenticationManager) //调用此方法才能支持 password 模式
                .userDetailsService(securityUserDetailsService)//设置用户验证服务
//                .tokenStore(redisTokenStore)//指定 token 的存储方式
                .tokenStore(jwtTokenStore)// 指定jwt token的方式
                .tokenEnhancer( enhancerChain )
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    /**
     * @Author DixonLim
     * @Date 2020/6/22 6:25 下午
     * @Param [security]
     * @Return void
     * @Description:这个方法限制客户端访问认证接口的权限
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("isAuthenticated()");
    }


}
