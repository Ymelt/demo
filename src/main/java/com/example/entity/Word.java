package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Word {
    private String content;
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private Timestamp dropTime;
}
