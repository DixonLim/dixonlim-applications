package com.dixonlim.oauth.service;


import com.dixonlim.oauth.model.SysUser;

import java.util.List;

/**
 * Created by DixonLim
 */
public interface SysUserService {

    SysUser save(SysUser sysUser);

    SysUser update(SysUser sysUser);

    SysUser findById(String id);

    List<SysUser> findAll();

    void  deleteById(String id);

    public SysUser findAllByUsername(String userName);
}
