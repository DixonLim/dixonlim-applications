package com.dixonlim.oauth.service.impl;

import com.dixonlim.oauth.model.SysUser;
import com.dixonlim.oauth.repository.SysUserRepository;
import com.dixonlim.oauth.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DixonLim
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    @CachePut(value = "user", key = "#sysUser.id", unless = "#result  eq null")
    public SysUser save(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    @CachePut(value = "user", key = "#sysUser.id")
    public SysUser update(SysUser sysUser) {
        return sysUserRepository.saveAndFlush(sysUser);
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public SysUser findById(String id) {
        return sysUserRepository.findAllById(id);
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    @CacheEvict(value = "user", key = "#id")
    public void deleteById(String id) {
        sysUserRepository.deleteById(id);
    }

    @Override
    public SysUser findAllByUsername(String userName) {
        return sysUserRepository.findAllByUsername(userName);
    }

}
