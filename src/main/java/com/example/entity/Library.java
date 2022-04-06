package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Library {


  @TableId(type = IdType.AUTO)
   private Integer id;


  private String codeValue;

    public Library() {
    }

    public Library(String codeValue) {
        this.codeValue = codeValue;
    }
}
