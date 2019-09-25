package com.security.demo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsRole implements Serializable{
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}
