package com.security.demo.service;

import com.security.demo.bean.UmsAdmin;
import com.security.demo.bean.UmsPermission;

import java.util.List;

public interface UmsAdminService {

    String login(String username, String password);

    UmsAdmin getAdminByUserName(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Integer adminId);
}
