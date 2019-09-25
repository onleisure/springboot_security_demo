package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsRolePermissionRelation implements Serializable{
    private int id;

    private int roleId;

    private int permissionId;

    private static final long serialVersionUID = 1L;
}
