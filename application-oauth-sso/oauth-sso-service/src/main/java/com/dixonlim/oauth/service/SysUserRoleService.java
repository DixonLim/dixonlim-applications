package com.dixonlim.oauth.service;


import com.dixonlim.oauth.model.SysUserRole;

import java.util.List;

/**
 * @Classname com.dixonlim.service.SysUserRoleService
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:51
 * @Description:
 */
public interface SysUserRoleService {

    public List<SysUserRole> findAllByUserId(String userId);

    public List<SysUserRole> findAllByRoleId(String roleId);
}
