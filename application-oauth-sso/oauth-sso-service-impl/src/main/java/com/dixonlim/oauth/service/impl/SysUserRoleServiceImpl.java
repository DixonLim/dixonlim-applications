package com.dixonlim.oauth.service.impl;

import com.dixonlim.oauth.model.SysUserRole;
import com.dixonlim.oauth.repository.SysUserRoleRepository;
import com.dixonlim.oauth.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname com.dixonlim.service.impl.SysUserRoleServiceImpl
 * @Auther: DixonLim
 * @Date: 2019/9/13 23:44
 * @Description:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {


    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Override
    public List<SysUserRole> findAllByUserId(String userId) {
        return sysUserRoleRepository.findAllByUserId(userId);
    }

    @Override
    public List<SysUserRole> findAllByRoleId(String roleId) {
        return sysUserRoleRepository.findAllByRoleId(roleId);
    }
}
