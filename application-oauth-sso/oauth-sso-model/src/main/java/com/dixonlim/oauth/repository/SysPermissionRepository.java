package com.dixonlim.oauth.repository;

import com.dixonlim.oauth.model.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname com.dixonlim.repository.SysPermissionRepository
 * @Auther: DixonLim
 * @Date: 2019/9/14 14:01
 * @Description:
 */
public interface SysPermissionRepository  extends JpaRepository<SysPermission, String> {

    public List<SysPermission> findAllByRoleId(String roleId);
}
