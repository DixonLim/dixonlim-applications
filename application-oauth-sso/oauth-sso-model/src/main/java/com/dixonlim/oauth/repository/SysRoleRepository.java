package com.dixonlim.oauth.repository;

import com.dixonlim.oauth.model.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname com.dixonlim.repository.SysRoleRepository
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:50
 * @Description:
 */
public interface SysRoleRepository extends JpaRepository<SysRole, String> {

    public SysRole findAllById(String id);

    public SysRole findAllByName(String name);
}
