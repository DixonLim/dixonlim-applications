package com.dixonlim.oauth;

import com.dixonlim.oauth.WebServerApplication;
import com.dixonlim.oauth.model.SysRole;
import com.dixonlim.oauth.model.SysUser;
import com.dixonlim.oauth.model.SysUserRole;
import com.dixonlim.oauth.repository.SysRoleRepository;
import com.dixonlim.oauth.repository.SysUserRepository;
import com.dixonlim.oauth.repository.SysUserRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 22:35
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebServerApplication.class)
public class UserRoleTest {

    @Autowired
    SysUserRepository sysUserRepository;
    @Autowired
    SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    SysRoleRepository sysRoleRepository;

    @Test
    public void createUserRole(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("order-secret-8888");
        System.out.println(password);
        password = passwordEncoder.encode("user-secret-8888");
        System.out.println(password);

//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("dixonlim");
//        sysUser.setPassword(passwordEncoder.encode("123456"));
//        sysUser =sysUserRepository.save(sysUser);

//        SysRole sysRole = new SysRole();
//        sysRole.setCode("role_user");
//        sysRole.setName("role_user");
//        sysRole =sysRoleRepository.save(sysRole);

//        SysUserRole sysUserRole = new SysUserRole();
//        sysUserRole.setUserId(sysUser.getId());
//        sysUserRole.setRoleId(sysRole.getId());
//        sysUserRoleRepository.save(sysUserRole);
    }
}
