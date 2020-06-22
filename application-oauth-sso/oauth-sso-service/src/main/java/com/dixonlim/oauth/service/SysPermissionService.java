package com.dixonlim.oauth.service;


import com.dixonlim.oauth.model.SysPermission;

import java.util.List;

/**
 * @Classname com.dixonlim.service.SysPermissionService
 * @Auther: DixonLim
 * @Date: 2019/9/14 14:02
 * @Description:
 */
public interface SysPermissionService {

    public List<SysPermission> findAllByRoleId(String roleId);
}
