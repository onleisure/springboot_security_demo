package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsPermission implements Serializable{
    private Integer id;

    private Integer pid;

    private String name;

    private String value;

    private String uri;

    private static final long serialVersionUID = 1L;
}
