package com.dixonlim.oauth.repository;

import com.dixonlim.oauth.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DixonLim
 */
public interface SysUserRepository extends JpaRepository<SysUser, String> {

    public SysUser findAllById(String id);

    public SysUser findAllByUsername(String userName);
}
