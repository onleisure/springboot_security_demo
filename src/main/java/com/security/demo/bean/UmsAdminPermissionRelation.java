package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsAdminPermissionRelation implements Serializable{
    private Integer id;

    private Integer adminId;

    private Integer permissionId;

    private Integer type;

    private static final long serialVersionUID = 1L;

}
