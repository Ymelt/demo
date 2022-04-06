package com.example.entity.vo;

import lombok.Data;

@Data
public class UserVo {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String email;
    private String code;
}
