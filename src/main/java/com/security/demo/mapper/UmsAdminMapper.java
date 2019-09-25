package com.security.demo.mapper;

import com.security.demo.bean.UmsAdmin;
import com.security.demo.bean.UmsAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsAdminMapper {
    List<UmsAdmin> selectByExample(UmsAdminExample example);

    List<UmsAdmin> selectByUsername(@Param("username") String username);

    int insert(UmsAdmin umsAdmin);
}
