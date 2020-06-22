package com.dixonlim.oauth.service.impl;

import com.dixonlim.oauth.model.SysRole;
import com.dixonlim.oauth.model.SysUser;
import com.dixonlim.oauth.model.SysUserRole;
import com.dixonlim.oauth.service.SysRoleService;
import com.dixonlim.oauth.service.SysUserRoleService;
import com.dixonlim.oauth.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @Classname com.dixonlim.service.impl.UserDetailsServiceImpl
 * @Auther: DixonLim
 * @Date: 2019/9/12 14:23
 * @Description: 实现Security-UserDetails方法,将用户信息和权限注入进来
 */
@Service
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysUserRoleService userRoleService;

    /**
     * @Author DixonLim
     * @Date 2019/9/13 11:59 下午
     * @Param [username]
     * @Return org.springframework.security.core.userdetails.UserDetails
     * @Description: 重写 loadUserByUsername 方法，参数是用户输入的用户名。
     * 返回值是UserDetails，这是一个接口，
     * 一般使用它的子类org.springframework.security.core.userdetails.User，
     * 它有三个参数，分别是用户名、密码和权限集
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        // 从数据库中取出用户信息
        SysUser user = userService.findAllByUsername(username);

        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<SysUserRole> userRoles = userRoleService.findAllByUserId(user.getId());
        for (SysUserRole userRole : userRoles) {
            SysRole role = roleService.findAllById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
