package com.dixonlim.oauth.repository;

import com.dixonlim.oauth.model.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname com.dixonlim.repository.SysUserRoleRepository
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:50
 * @Description:
 */
public interface SysUserRoleRepository  extends JpaRepository<SysUserRole, String> {


    public List<SysUserRole> findAllByUserId(String userId);

    public List<SysUserRole> findAllByRoleId(String roleId);
}
