package com.dixonlim.oauth.service.impl;

import com.dixonlim.oauth.model.SysRole;
import com.dixonlim.oauth.repository.SysRoleRepository;
import com.dixonlim.oauth.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname com.dixonlim.service.impl.SysRoleServiceImpl
 * @Auther: DixonLim
 * @Date: 2019/9/13 23:44
 * @Description:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public SysRole findAllById(String id) {
        return sysRoleRepository.findAllById(id);
    }

    @Override
    public SysRole findAllByName(String name) {
        return sysRoleRepository.findAllByName(name);
    }
}
