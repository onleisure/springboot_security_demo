package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsAdminRoleRelation implements Serializable{
    private Integer id;

    private Integer adminId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}
