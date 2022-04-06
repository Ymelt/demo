package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface UserMapper extends BaseMapper<User> {

//    @Insert("INSERT INTO library VALUES (#{code})")
//    String insertcode(@Param("code_value") String code);

//    @Select("SELECT * from user")
//    List<User> findAll();
//
//    @Insert("INSERT INTO user(user_name,user_password) VALUES (#{userName},#{userPassword})")
//    int insert(User user);
//
//    int update(User user);
//
//    @Delete("delete from user where user_id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from user where user_name like concat('%',#{username},'%') limit #{pageNum},#{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize,String username);
//
//    @Select("select count(*) from user where user_name like concat('%',#{username},'%')")
//    Integer selectTotal(String username);
}
