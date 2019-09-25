package com.security.demo.service.impl;

import com.security.demo.bean.UmsAdmin;
import com.security.demo.bean.UmsAdminExample;
import com.security.demo.bean.UmsPermission;
import com.security.demo.mapper.UmsAdminMapper;
import com.security.demo.mapper.UmsAdminRoleRelationDao;
import com.security.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsAdminServiceImpl implements UmsAdminService{
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password.replace("\"",""),userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
//            updateLoginTimeByUsername(username);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public UmsAdmin getAdminByUserName(String username) {
        UmsAdminExample example = new UmsAdminExample();
        //example.createCriteria().andUsernameEqualTo(username);
        //List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        List<UmsAdmin> adminList = adminMapper.selectByUsername(username);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsPermission> getPermissionList(Integer adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}
