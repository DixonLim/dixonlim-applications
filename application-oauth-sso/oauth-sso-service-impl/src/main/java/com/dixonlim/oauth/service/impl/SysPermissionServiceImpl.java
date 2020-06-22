package com.dixonlim.oauth.service.impl;

import com.dixonlim.oauth.model.SysPermission;
import com.dixonlim.oauth.repository.SysPermissionRepository;
import com.dixonlim.oauth.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname com.dixonlim.service.impl.SysPermissionServiceImpl
 * @Auther: DixonLim
 * @Date: 2019/9/14 14:03
 * @Description:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {


    @Autowired
    private SysPermissionRepository sysPermissionRepository;
    @Override
    public List<SysPermission> findAllByRoleId(String roleId) {
        return sysPermissionRepository.findAllByRoleId(roleId);
    }
}
