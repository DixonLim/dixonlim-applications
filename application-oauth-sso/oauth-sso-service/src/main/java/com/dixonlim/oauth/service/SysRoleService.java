package com.dixonlim.oauth.service;


import com.dixonlim.oauth.model.SysRole;

/**
 * @Classname com.dixonlim.service.SysRoleService
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:51
 * @Description:
 */
public interface SysRoleService {

    public SysRole findAllById(String id);

    public SysRole findAllByName(String name);
}
