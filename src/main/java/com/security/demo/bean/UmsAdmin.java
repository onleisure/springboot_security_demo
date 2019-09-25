package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsAdmin implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private static final long serialVersionUID = 1L;
}
